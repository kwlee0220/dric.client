package dric.dataset.mqtt;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dric.dataset.mqtt.MqttSessionFactory.MqttSession;
import marmot.RecordReader;
import marmot.RecordSchema;
import marmot.RecordStream;
import marmot.RecordStreamException;
import marmot.avro.AvroDeserializer;
import marmot.avro.AvroRecord;
import marmot.stream.PipedRecordStream;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class MqttAvroRecordReader implements RecordReader {
	@SuppressWarnings("unused")
	private static final Logger s_logger = LoggerFactory.getLogger(MqttAvroRecordWriter.class);
	private static final int CONNECT_TIMEOUT = 60*60*24*7;	// 1 week
	
	private final String m_brokerHost;
	private final int m_brokerPort;
	private final String m_clientId;
	private final String m_topic;
	private final RecordSchema m_schema;
	private final AvroDeserializer m_deserializer;
	private final MqttSessionFactory m_sessionFact;
	
	public MqttAvroRecordReader(String brokerHost, int brokerPort, String clientId, String topic,
								RecordSchema schema, Schema avroSchema) {
		m_brokerHost = brokerHost;
		m_brokerPort = brokerPort;
		m_clientId = clientId;
		m_topic = topic;
		m_schema = schema;
		m_deserializer = new AvroDeserializer(avroSchema);
		m_sessionFact = new MqttSessionFactory(m_brokerHost, m_brokerPort, m_clientId)
								.setAutoReconnect(true)
								.setConnectTimeout(CONNECT_TIMEOUT);
	}

	@Override
	public RecordSchema getRecordSchema() {
		return m_schema;
	}

	@Override
	public RecordStream read() {
		@SuppressWarnings("resource")
		PipedRecordStream strm = new PipedRecordStream(m_schema, 16);
		
		MqttSession session = null;
		try {
			session = m_sessionFact.create();
			session.subscribe(m_topic, (topic, msg) -> {
				GenericRecord grec = m_deserializer.deserialize(msg.getPayload());
				AvroRecord record = new AvroRecord(m_schema, grec);
				strm.supply(record);
			});
				
			return strm.onClose(session::close);
		}
		catch ( MqttException e ) {
			throw new RecordStreamException("fails to create MqttAvroRecordReader", e);
		}
	}
}

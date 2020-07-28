package dric.topic.mqtt;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	private final Logger s_logger = LoggerFactory.getLogger(MqttAvroRecordWriter.class);
	
	private final String m_brokerHost;
	private final int m_brokerPort;
	private final String m_topic;
	private final RecordSchema m_schema;
	private final AvroDeserializer m_deserializer;
	
	public MqttAvroRecordReader(String brokerHost, int brokerPort, String topic,
								RecordSchema schema, Schema avroSchema) {
		m_brokerHost = brokerHost;
		m_brokerPort = brokerPort;
		m_topic = topic;
		m_schema = schema;
		m_deserializer = new AvroDeserializer(avroSchema);
	}

	@Override
	public RecordSchema getRecordSchema() {
		return m_schema;
	}

	@Override
	public RecordStream read() {
		PipedRecordStream strm = new PipedRecordStream(m_schema, 16);
		@SuppressWarnings("resource")
		MqttSession session = new MqttSession(m_brokerHost, m_brokerPort)
									.setAutoReconnect(true)
									.setConnectTimeout(60*60*24*7);
		try {
			session.connect(true);
			session.subscribe(m_topic, (topic, msg) -> {
				GenericRecord grec = m_deserializer.deserialize(msg.getPayload());
				AvroRecord record = new AvroRecord(m_schema, grec);
				strm.supply(record);
			});
				
			return strm;
		}
		catch ( MqttException e ) {
			throw new RecordStreamException("fails to create RecordStream", e);
		}
	}
}

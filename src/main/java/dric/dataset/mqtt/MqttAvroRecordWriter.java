package dric.dataset.mqtt;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dric.dataset.mqtt.MqttSessionFactory.MqttSession;
import marmot.Record;
import marmot.RecordSchema;
import marmot.RecordStream;
import marmot.RecordStreamException;
import marmot.RecordWriter;
import marmot.avro.AvroSerializer;
import marmot.avro.AvroUtils;


/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class MqttAvroRecordWriter implements RecordWriter {
	private final Logger s_logger = LoggerFactory.getLogger(MqttAvroRecordWriter.class);
	
	private final MqttSessionFactory m_fact;
	private final String m_topicName;
	private final RecordSchema m_schema;
	private final Schema m_avroSchema;
	
	public MqttAvroRecordWriter(String host, int port, String clientId, String topicName,
								RecordSchema schema, Schema avroSchema) {
		m_topicName = topicName;
		m_schema = schema;
		m_avroSchema = avroSchema;
		m_fact = new MqttSessionFactory(host, port, clientId)
						.setAutoReconnect(true)
						.setConnectTimeout(60*60*24*7);
	}

	@Override
	public RecordSchema getRecordSchema() {
		return m_schema;
	}

	@Override
	public long write(RecordStream stream) {
		long count = 0;
		AvroSerializer serializer = new AvroSerializer(m_avroSchema);
		try ( MqttSession session = m_fact.create() ) {
			for ( Record record = stream.next(); record != null; record = stream.next() ) {
				try {
					GenericRecord grec = AvroUtils.toGenericRecord(record, m_avroSchema);
					byte[] bytes = serializer.serializeToBytes(grec);
					MqttMessage msg = new MqttMessage(bytes);
					msg.setQos(0);
					msg.setRetained(true);
					session.publish(m_topicName, msg);
					
					++count;
				}
				catch ( Exception ignored ) {
					s_logger.debug(String.format("fails to publish a record: cause=" + ignored));
				}
			}
		}
		catch ( Exception e ) {
			throw new RecordStreamException("fails to open MqttSession: " + m_fact, e);
		}
		
		return count;
	}
}

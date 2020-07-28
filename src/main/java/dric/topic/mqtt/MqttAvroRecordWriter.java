package dric.topic.mqtt;

import java.util.concurrent.Callable;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import marmot.Record;
import marmot.RecordStream;
import marmot.RecordWriter;
import marmot.avro.AvroSerializer;
import marmot.avro.AvroUtils;


/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class MqttAvroRecordWriter implements RecordWriter {
	private final Logger s_logger = LoggerFactory.getLogger(MqttAvroRecordWriter.class);
	
	private final MqttSession m_session;
	private final String m_topicName;
	private final Schema m_avroSchema;
	
	public MqttAvroRecordWriter(String host, int port, String topicName, Schema avroSchema) {
		m_topicName = topicName;
		m_avroSchema = avroSchema;
		m_session = new MqttSession(host, port).setAutoReconnect(true).setConnectTimeout(60*60*24*7);
	}

	@Override
	public long write(RecordStream stream) {
		m_session.connectAsync(true);
		
		long count = 0;
		AvroSerializer serializer = new AvroSerializer(m_avroSchema);
		for ( Record record = stream.next(); record != null; record = stream.next() ) {
			try {
				GenericRecord grec = AvroUtils.toGenericRecord(record, m_avroSchema);
				byte[] bytes = serializer.serializeToBytes(grec);
				MqttMessage msg = new MqttMessage(bytes);
				msg.setQos(0);
				msg.setRetained(true);
				m_session.publish(m_topicName, msg);
				
				++count;
			}
			catch ( Exception ignored ) {
				s_logger.debug(String.format("fails to publish a record: cause=" + ignored));
			}
		}
		
		return count;
	}
	
//	class PublishingWork implements Callable<Long> {
//		private final RecordStream m_stream;
//		private final AvroSerializer m_serializer;
//		
//		PublishingWork(RecordStream stream) {
//			m_stream = stream;
//			m_serializer = new AvroSerializer(m_avroSchema);
//		}
//		
//		@Override
//		public Long call() {
//			m_session.connectAsync(true);
//			
//			long count = 0;
//			for ( Record record = m_stream.next(); record != null; record = m_stream.next() ) {
//				try {
//					GenericRecord grec = AvroUtils.toGenericRecord(record, m_avroSchema);
//					byte[] bytes = m_serializer.serializeToBytes(grec);
//					MqttMessage msg = new MqttMessage(bytes);
//					msg.setQos(0);
//					msg.setRetained(true);
//					m_session.publish(m_topicName, msg);
//					
//					++count;
//				}
//				catch ( Exception ignored ) {
//					s_logger.debug(String.format("fails to publish a record: cause=" + ignored));
//				}
//			}
//			
//			return count;
//		}
//	}
}

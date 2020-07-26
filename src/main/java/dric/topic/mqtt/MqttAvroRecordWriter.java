package dric.topic.mqtt;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;

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
	private final IMqttClient m_client;
	private final String m_name;
	
	public MqttAvroRecordWriter(IMqttClient client, String name) {
		m_client = client;
		m_name = name;
	}

	@Override
	public long write(RecordStream stream) {
		RecordSchema schema = stream.getRecordSchema();
		Schema avroSchema = AvroUtils.toSchema(schema);
		AvroSerializer serializer = new AvroSerializer(avroSchema);
		
		long count = 0;
		for ( Record record = stream.next(); record != null; record = stream.next() ) {
			try {
				GenericRecord grec = AvroUtils.toGenericRecord(record, avroSchema);
				byte[] bytes = serializer.serializeToBytes(grec);
				MqttMessage msg = new MqttMessage(bytes);
				msg.setQos(0);
				msg.setRetained(true);
				m_client.publish(m_name, msg);
				
				++count;
			}
			catch ( Exception e ) {
				throw new RecordStreamException("fails to publish record" + e);
			}
		}
		
		return count;
	}

}

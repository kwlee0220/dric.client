package dric.topic.mqtt;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import marmot.RecordReader;
import marmot.RecordSchema;
import marmot.RecordStream;
import marmot.RecordStreamException;
import marmot.avro.AvroDeserializer;
import marmot.avro.AvroRecord;
import marmot.avro.AvroUtils;
import marmot.stream.PipedRecordStream;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class MqttAvroRecordReader implements RecordReader {
	private final IMqttClient m_client;
	private final String m_name;
	private final RecordSchema m_schema;
	private final Schema m_avroSchema;
	private final AvroDeserializer m_deserializer;
	
	public MqttAvroRecordReader(IMqttClient client, String name, RecordSchema schema) {
		m_client = client;
		m_name = name;
		m_schema = schema;
		m_avroSchema = AvroUtils.toSchema(schema);
		m_deserializer = new AvroDeserializer(m_avroSchema);
	}

	@Override
	public RecordSchema getRecordSchema() {
		return m_schema;
	}

	@Override
	public RecordStream read() {
		PipedRecordStream strm = new PipedRecordStream(m_schema, 16);
		try {
			m_client.setCallback(new MqttCallback() {
				@Override
				public void messageArrived(String topic, MqttMessage msg) throws Exception {
					GenericRecord grec = m_deserializer.deserialize(msg.getPayload());
					AvroRecord record = new AvroRecord(m_schema, grec);
					strm.supply(record);
				}
				
				@Override
				public void deliveryComplete(IMqttDeliveryToken token) { }
				
				@Override
				public void connectionLost(Throwable cause) {
					strm.endOfSupply(cause);
				}
			});
			m_client.subscribe(m_name);
			
			return strm;
		}
		catch ( Exception e ) {
			throw new RecordStreamException("fails to read from Mqtt topic: name=" + m_name, e);
		}
	}
}

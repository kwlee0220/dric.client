package dric.store;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class MqttTopic {
	private final IMqttClient m_client;
	private final String m_topic;
	private final Schema m_schema;
	private final SpecificDatumReader<GenericRecord> m_reader;
	private final SpecificDatumWriter<GenericRecord> m_writer;
	
	MqttTopic(IMqttClient client, String topic, Schema schema) {
		m_client = client;
		m_topic = topic;
		m_schema = schema;
		
		m_reader = new SpecificDatumReader<>(schema);
		m_writer = new SpecificDatumWriter<>(schema);
	}

	public void publish(GenericRecord data) throws MqttPersistenceException, MqttException, IOException {
        MqttMessage msg = new MqttMessage(toMessageByteArray(data));
        msg.setQos(0);
        msg.setRetained(true);
        m_client.publish(m_topic, msg);
	}
	
	public void subscribe(TopicMessageListener listener) throws MqttSecurityException, MqttException {
		m_client.subscribe(m_topic,
				(topic, msg) -> listener.onMessageArrived(m_topic, fromByteArray(msg.getPayload())));
	}
	
	private byte[] toMessageByteArray(GenericRecord msg) throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		BinaryEncoder encoder = EncoderFactory.get().binaryEncoder(baos, null);
		
		m_writer.write(msg, encoder);
		encoder.flush();
		
		return baos.toByteArray();
	}
	
	private GenericRecord fromByteArray(byte[] bytes) throws IOException {
		BinaryDecoder decoder = DecoderFactory.get().binaryDecoder(bytes, null);
		return m_reader.read(null, decoder);
	}
}

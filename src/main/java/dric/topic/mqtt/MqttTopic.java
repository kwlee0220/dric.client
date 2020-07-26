package dric.topic.mqtt;

import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericRecord;
import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import dric.topic.Topic;
import dric.topic.TopicException;
import dric.topic.TopicSubscriber;
import dric.type.AvroSerializable;
import marmot.avro.AvroDeserializer;
import marmot.avro.AvroSerializer;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public abstract class MqttTopic<T extends AvroSerializable> implements Topic<T> {
	private final IMqttClient m_client;
	private final String m_name;
	private final AvroSerializer m_serializer;
	private final AvroDeserializer m_deserializer;
	
	protected abstract T fromGenicRecord(GenericRecord record) throws IOException;
	
	public MqttTopic(IMqttClient client, String name, Schema avroSchema) {
		m_client = client;
		m_name = name;
		m_serializer = new AvroSerializer(avroSchema);
		m_deserializer = new AvroDeserializer(avroSchema);
	}
	
	@Override
	public void publish(T data) throws TopicException {
        try {
        	byte[] bytes = m_serializer.serializeToBytes(data.toGenericRecord());
			MqttMessage msg = new MqttMessage(bytes);
			msg.setQos(0);
			msg.setRetained(true);
			m_client.publish(m_name, msg);
		}
		catch ( Exception e ) {
			throw new TopicException("" + e);
		}
	}
	
	@Override
	public void subscribe(TopicSubscriber<T> subscriber) throws TopicException {
		try {
			m_client.subscribe(m_name,
					(topic, msg) -> subscriber.onMessageArrived(m_name, deserialize(msg)));
		}
		catch ( Exception e ) {
			throw new TopicException("" + e);
		}
	}

	protected T deserialize(MqttMessage msg) throws IOException {
		return fromGenicRecord(m_deserializer.deserialize(msg.getPayload()));
	}
}

package dric.topic.mqtt;

import java.io.IOException;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import com.google.protobuf.MessageLite;

import dric.topic.Topic;
import dric.topic.TopicException;
import dric.topic.TopicSubscriber;
import dric.type.PBSerializable;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public abstract class MqttTopic<T extends PBSerializable<? extends MessageLite>> implements Topic<T> {
	private final IMqttClient m_client;
	private final String m_name;
	
	protected abstract T fromMqttMessage(MqttMessage mqttMsg) throws IOException;
	
	public MqttTopic(IMqttClient client, String name) {
		m_client = client;
		m_name = name;
	}
	
	@Override
	public void publish(T data) throws TopicException {
        try {
			MqttMessage msg = new MqttMessage(data.toProto().toByteArray());
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
					(topic, msg) -> subscriber.onMessageArrived(m_name, fromMqttMessage(msg)));
		}
		catch ( Exception e ) {
			throw new TopicException("" + e);
		}
	}
}

package dric.topic.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttClient;

import dric.topic.Topic;
import dric.topic.TopicClient;
import dric.type.CameraFrame;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class MqttTopicClient implements TopicClient {
	private final IMqttClient m_client;
	
	public MqttTopicClient(IMqttClient client) {
		m_client = client;
	}

	@Override
	public Topic<CameraFrame> getCameraFrameTopic() {
		return new MqttCameraFrameTopic(m_client);
	}
}

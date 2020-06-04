package dric.store;

import java.io.IOException;
import java.io.UncheckedIOException;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

import com.google.protobuf.InvalidProtocolBufferException;

import dric.proto.CameraFrameProto;
import dric.type.CameraFrame;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class TopicCameraFrame {
	private final IMqttClient m_client;
	private final String m_topic;
	
	TopicCameraFrame(IMqttClient client) {
		this(client, "dric/camera_frames");
	}
	
	TopicCameraFrame(IMqttClient client, String topic) {
		m_client = client;
		m_topic = topic;
	}

	public void publish(CameraFrame data) throws MqttPersistenceException, MqttException,
														IOException {
        MqttMessage msg = new MqttMessage(data.toProto().toByteArray());
        msg.setQos(0);
        msg.setRetained(true);
        m_client.publish(m_topic, msg);
	}
	
	public void subscribe(CameraFrameListener listener)
		throws MqttSecurityException, MqttException {
		m_client.subscribe(m_topic,
				(topic, msg) -> listener.onMessageArrived(m_topic, fromMqttMessage(msg)));
	}
	
	private CameraFrame fromMqttMessage(MqttMessage msg) {
		try {
			return CameraFrame.fromProto(CameraFrameProto.parseFrom(msg.getPayload()));
		}
		catch ( InvalidProtocolBufferException e ) {
			throw new UncheckedIOException(e);
		}
	}
}
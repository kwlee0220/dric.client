package dric.topic.mqtt;

import java.io.IOException;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import dric.proto.CameraFrameProto;
import dric.type.CameraFrame;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class MqttCameraFrameTopic extends MqttTopic<CameraFrame> {
	public MqttCameraFrameTopic(IMqttClient client, String name) {
		super(client, name);
	}
	
	public MqttCameraFrameTopic(IMqttClient client) {
		super(client, "dric/camera_frames");
	}

	@Override
	protected CameraFrame fromMqttMessage(MqttMessage msg) throws IOException {
		return CameraFrame.fromProto(CameraFrameProto.parseFrom(msg.getPayload()));
	}
}

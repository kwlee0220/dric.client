package dric.topic.mqtt;

import java.io.IOException;

import org.apache.avro.generic.GenericRecord;
import org.eclipse.paho.client.mqttv3.IMqttClient;

import dric.type.CameraFrame;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class MqttCameraFrameTopic extends MqttTopic<CameraFrame> {
	public MqttCameraFrameTopic(IMqttClient client, String name) {
		super(client, name, CameraFrame.getAvroSchema());
	}
	
	public MqttCameraFrameTopic(IMqttClient client) {
		super(client, CameraFrame.getTopicName(), CameraFrame.getAvroSchema());
	}

	@Override
	protected CameraFrame fromGenicRecord(GenericRecord record) throws IOException {
		return CameraFrame.fromGenericRecord(record);
	}
}

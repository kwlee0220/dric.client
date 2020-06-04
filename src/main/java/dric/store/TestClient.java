package dric.store;

import java.io.File;

import org.eclipse.paho.client.mqttv3.IMqttClient;

import dric.ClientConfig;
import dric.DrICClient;
import dric.type.CameraFrame;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class TestClient {
	public static final void main(String... args) throws Exception {
		ClientConfig config = ClientConfig.from(new File("configs/dric_client.yaml"));
		
		SchemaRegistry reg = SchemaRegistry.get();
		DrICClient client = DrICClient.connect("test", config);
		IMqttClient mqtt = client.getIMqttClient();
		TopicCameraFrame topic = new TopicCameraFrame(mqtt);
		
		topic.publish(new CameraFrame("cam_1", new byte[0], 1));
		topic.publish(new CameraFrame("cam_1", new byte[0], 1));
		topic.publish(new CameraFrame("cam_1", new byte[0], 1));
		topic.publish(new CameraFrame("cam_1", new byte[0], 1));
		
//		GenericRecord datum = new GenericData.Record(schema);
//		datum.put("left", "L");
//		datum.put("right", "R");
//		
//		ByteArrayOutputStream  out = new ByteArrayOutputStream();
//		DatumWriter<GenericRecord> writer = new GenericDatumWriter<>(schema);
//		Encoder encoder = EncoderFactory.get().binaryEncoder(out, null);
//		writer.write(datum, encoder);
//		encoder.flush();
//		out.close();
//		
//		byte[] bytes = out.toByteArray();
//		System.out.println("length=" + bytes.length);
//		
//		DatumReader<GenericRecord> reader = new GenericDatumReader<>(schema);
//		Decoder decoder = DecoderFactory.get().binaryDecoder(bytes, null);
//		GenericRecord result = reader.read(null, decoder);
//		System.out.println(result);
	}
}

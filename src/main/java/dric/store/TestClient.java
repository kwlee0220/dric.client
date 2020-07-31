package dric.store;

import dric.DrICClient;
import dric.type.CameraFrame;
import marmot.Record;
import marmot.RecordStream;
import marmot.dataset.DataSet;
import marmot.remote.client.GrpcDataSetServerProxy;
import marmot.remote.client.GrpcMarmotRuntimeProxy;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class TestClient {
	public static final void main(String... args) throws Exception {
		DrICClient client = DrICClient.connect("localhost", 10703, "test");
		
		System.out.println(client.getPlatform().getServiceEndPoint("topic_server"));
		
		GrpcMarmotRuntimeProxy marmot = client.getMarmotServer();
		GrpcDataSetServerProxy dsServer = marmot.getDataSetServer();
		
		DataSet ds = marmot.getDataSetServer().getDataSet(CameraFrame.DATASET_ID);
		try ( RecordStream strm = ds.read() ) {
			for ( Record record = strm.next(); record != null; record = strm.next() ) {
				System.out.println(record.getString(0));
			}
		}
		System.out.println(ds);
		
//		IMqttClient mqtt = client.getIMqttClient("test");
//		TopicCameraFrame topic = new TopicCameraFrame(mqtt);
//		
//		topic.publish(new CameraFrame("cam_1", new byte[0], 1));
//		topic.publish(new CameraFrame("cam_1", new byte[0], 1));
//		topic.publish(new CameraFrame("cam_1", new byte[0], 1));
//		topic.publish(new CameraFrame("cam_1", new byte[0], 1));
		
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

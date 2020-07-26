package dric.type;

import java.nio.ByteBuffer;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;

import com.google.protobuf.ByteString;

import dric.proto.CameraFrameProto;
import marmot.RecordSchema;
import marmot.avro.AvroUtils;
import marmot.type.DataType;


/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class CameraFrame implements AvroSerializable {
	private static final RecordSchema RECORD_SCHEMA = RecordSchema.builder()
																.addColumn("camera_id", DataType.STRING)
																.addColumn("image", DataType.BINARY)
																.addColumn("ts", DataType.LONG)
																.build();
	private static Schema AVRO_SCHEMA = AvroUtils.toSchema(RECORD_SCHEMA);
	private static String TOPIC_NAME = "dric/camera_frames";
	
	private final String m_cameraId;
	private final byte[] m_image;
	private final long m_ts;
	
	public CameraFrame(String cameraId, byte[] image, long ts) {
		m_cameraId = cameraId;
		m_image = image;
		m_ts = ts;
	}
	
	public static RecordSchema getRecordSchema() {
		return RECORD_SCHEMA;
	}
	
	public static Schema getAvroSchema() {
		return AVRO_SCHEMA;
	}
	
	public static String getTopicName() {
		return TOPIC_NAME;
	}
	
	@Override
	public Schema schema() {
		return AVRO_SCHEMA;
	}
	
	public String cameraId() {
		return m_cameraId;
	}
	
	public byte[] image() {
		return m_image;
	}
	
	public long ts() {
		return m_ts;
	}
	
	@Override
	public GenericRecord toGenericRecord() {
		GenericRecord grec = new GenericData.Record(schema());
		grec.put("camera_id", m_cameraId);
		grec.put("image", ByteBuffer.wrap(m_image));
		grec.put("ts", m_ts);
		
		return grec;
	}

	public static CameraFrame fromGenericRecord(GenericRecord grec) {
		String cameraId = grec.get("camera_id").toString();
		ByteBuffer bbuf = (ByteBuffer)grec.get("image");
		byte[] image = bbuf.array();
		long ts = (long)grec.get("ts");
		
		return new CameraFrame(cameraId, image, ts);
	}
}

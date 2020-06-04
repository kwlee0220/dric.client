package dric.type;

import java.nio.ByteBuffer;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;

import com.google.protobuf.ByteString;

import dric.proto.CameraFrameProto;
import dric.store.SchemaRegistry;


/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class CameraFrame implements AvroSerializable, PBSerializable<CameraFrameProto> {
	private static final String FULL_NAME = "dric.CameraFrame";
	private static Schema SCHEMA;
	
	private final String m_cameraId;
	private final byte[] m_image;
	private final long m_ts;
	
	public CameraFrame(String cameraId, byte[] image, long ts) {
		m_cameraId = cameraId;
		m_image = image;
		m_ts = ts;
	}
	
	@Override
	public Schema schema() {
		if ( SCHEMA == null ) {
			SCHEMA = SchemaRegistry.get()
									.get(FULL_NAME)
									.getOrThrow(() -> new SchemaNotFoundException(FULL_NAME));
		}
		
		return SCHEMA;
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

	@Override
	public CameraFrameProto toProto() {
		return CameraFrameProto.newBuilder()
								.setCameraId(m_cameraId)
								.setImage(ByteString.copyFrom(m_image))
								.setTs(m_ts)
								.build();
	}

	public static CameraFrame fromProto(CameraFrameProto proto) {
		return new CameraFrame(proto.getCameraId(), proto.getImage().toByteArray(), proto.getTs());
	}
}

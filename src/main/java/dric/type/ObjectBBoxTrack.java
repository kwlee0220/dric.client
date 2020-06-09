package dric.type;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;

import dric.proto.ObjectBBoxTrackProto;
import dric.store.SchemaRegistry;


/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class ObjectBBoxTrack implements AvroSerializable, PBSerializable<ObjectBBoxTrackProto>  {
	private static final String FULL_NAME = "dric.ObjectBBoxTrack";
	private static Schema SCHEMA;
	
	private final String m_cameraId;
	private final String m_luid;
	private final BoundingBox m_bbox;
	private final float m_heading;
	private final long m_ts;
	
	public ObjectBBoxTrack(String cameraId, String luid, BoundingBox bbox, float heading, long ts) {
		m_cameraId = cameraId;
		m_luid = luid;
		m_bbox = bbox;
		m_heading = heading;
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
	
	public String luid() {
		return m_luid;
	}
	
	public BoundingBox bbox() {
		return m_bbox;
	}
	
	public float heading() {
		return m_heading;
	}
	
	public long ts() {
		return m_ts;
	}
	
	@Override
	public GenericRecord toGenericRecord() {
		GenericRecord grec = new GenericData.Record(schema());
		grec.put("camera_id", m_cameraId);
		grec.put("luid", m_luid);
		grec.put("bbox", m_bbox.toGenericRecord());
		grec.put("heading", m_heading);
		grec.put("ts", m_ts);
		
		return grec;
	}

	public static ObjectBBoxTrack fromGenericRecord(GenericRecord grec) {
		String cameraId = grec.get("camera_id").toString();
		String luid = grec.get("luid").toString();
		BoundingBox bbox = BoundingBox.fromGenericRecord((GenericRecord)grec.get("bbox"));
		int heading = (int)grec.get("heading");
		long ts = (long)grec.get("ts");
		
		return new ObjectBBoxTrack(cameraId, luid, bbox, heading, ts);
	}

	@Override
	public ObjectBBoxTrackProto toProto() {
		return ObjectBBoxTrackProto.newBuilder()
								.setCameraId(m_cameraId)
								.setLuid(m_luid)
								.setBbox(m_bbox.toProto())
								.setHeading(m_heading)
								.setTs(m_ts)
								.build();
	}

	public static ObjectBBoxTrack fromProto(ObjectBBoxTrackProto proto) {
		return new ObjectBBoxTrack(proto.getCameraId(), proto.getLuid(), BoundingBox.fromProto(proto.getBbox()),
									proto.getHeading(), proto.getTs());
	}
}

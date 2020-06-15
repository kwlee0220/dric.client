package dric.type;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;

import dric.proto.ObjectTrackProto;
import dric.store.SchemaRegistry;


/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class ObjectTrack implements AvroSerializable, PBSerializable<ObjectTrackProto>  {
	private static final String FULL_NAME = "dric.ObjectTrack";
	private static Schema SCHEMA;
	
	private final String m_cameraId;
	private final String m_luid;
	private final String m_objClass;
	private final Coordinate m_coord;
	private final float m_azimuth;
	private final long m_ts;
	
	public ObjectTrack(String cameraId, String luid, String objClass, Coordinate coord,
						float azimuth, long ts) {
		m_cameraId = cameraId;
		m_luid = luid;
		m_objClass = objClass;
		m_coord = coord;
		m_azimuth = azimuth;
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
	
	public String objectClass() {
		return m_objClass;
	}
	
	public Coordinate coordinate() {
		return m_coord;
	}
	
	public float heading() {
		return m_azimuth;
	}
	
	public long ts() {
		return m_ts;
	}
	
	@Override
	public GenericRecord toGenericRecord() {
		GenericRecord grec = new GenericData.Record(schema());
		grec.put("camera_id", m_cameraId);
		grec.put("luid", m_luid);
		grec.put("object_class", m_objClass);
		grec.put("coordinate", m_coord.toGenericRecord());
		grec.put("heading", m_azimuth);
		grec.put("ts", m_ts);
		
		return grec;
	}

	public static ObjectTrack fromGenericRecord(GenericRecord grec) {
		String cameraId = grec.get("camera_id").toString();
		String luid = grec.get("luid").toString();
		String objCls = grec.get("object_class").toString();
		Coordinate bbox = Coordinate.fromGenericRecord((GenericRecord)grec.get("coordinate"));
		int heading = (int)grec.get("heading");
		long ts = (long)grec.get("ts");
		
		return new ObjectTrack(cameraId, luid, objCls, bbox, heading, ts);
	}

	@Override
	public ObjectTrackProto toProto() {
		return ObjectTrackProto.newBuilder()
								.setCameraId(m_cameraId)
								.setLuid(m_luid)
								.setObjectClass(m_objClass)
								.setCoordinate(m_coord.toProto())
								.setAzimuth(m_azimuth)
								.setTs(m_ts)
								.build();
	}

	public static ObjectTrack fromProto(ObjectTrackProto proto) {
		return new ObjectTrack(proto.getCameraId(), proto.getLuid(), proto.getObjectClass(),
								Coordinate.fromProto(proto.getCoordinate()),
								proto.getAzimuth(), proto.getTs());
	}
}

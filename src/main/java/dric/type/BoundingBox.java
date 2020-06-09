package dric.type;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;

import dric.proto.BoundingBoxProto;
import dric.store.SchemaRegistry;


/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class BoundingBox implements AvroSerializable, PBSerializable<BoundingBoxProto> {
	private static final String FULL_NAME = "dric.BoundingBox";
	private static Schema SCHEMA;
	
	private final ImageCoordinate m_tl;
	private final ImageCoordinate m_br;
	
	public BoundingBox(ImageCoordinate tl, ImageCoordinate br) {
		m_tl = tl;
		m_br = br;
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
	
	public ImageCoordinate tl() {
		return m_tl;
	}
	
	public ImageCoordinate br() {
		return m_br;
	}
	
	@Override
	public GenericRecord toGenericRecord() {
		GenericRecord grec = new GenericData.Record(schema());
		grec.put("tl", m_tl.toGenericRecord());
		grec.put("br", m_br.toGenericRecord());
		
		return grec;
	}

	public static BoundingBox fromGenericRecord(GenericRecord grec) {
		ImageCoordinate tl = ImageCoordinate.fromGenericRecord((GenericRecord)grec.get("tl"));
		ImageCoordinate br = ImageCoordinate.fromGenericRecord((GenericRecord)grec.get("br"));
		
		return new BoundingBox(tl, br);
	}

	@Override
	public BoundingBoxProto toProto() {
		return BoundingBoxProto.newBuilder()
								.setTl(m_tl.toProto())
								.setBr(m_br.toProto())
								.build();
	}

	public static BoundingBox fromProto(BoundingBoxProto proto) {
		return new BoundingBox(ImageCoordinate.fromProto(proto.getTl()), ImageCoordinate.fromProto(proto.getBr()));
	}
}

package dric.type;

import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;

import dric.proto.CoordinateProto;
import dric.store.AvroUtils;
import dric.store.SchemaRegistry;


/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class Coordinate implements AvroSerializable, PBSerializable<CoordinateProto> {
	private static final String FULL_NAME = "dric.Coordinate";
	private static Schema SCHEMA;
	
	private final double m_x;
	private final double m_y;
	
	public Coordinate(double x, double y) {
		m_x = x;
		m_y = y;
	}
	
	@Override
	public Schema schema() {
		if ( SCHEMA == null ) {
			SCHEMA = SchemaRegistry.get().getUnchecked(FULL_NAME);
		}
		
		return SCHEMA;
	}
	
	public double x() {
		return m_x;
	}
	
	public double y() {
		return m_y;
	}
	
	@Override
	public GenericRecord toGenericRecord() {
		GenericRecord grec = new GenericData.Record(schema());
		grec.put("x", m_x);
		grec.put("y", m_y);
		
		return grec;
	}

	public static Coordinate fromGenericRecord(GenericRecord grec) {
		int x = (int)grec.get("x");
		int y = (int)grec.get("y");
		
		return new Coordinate(x, y);
	}

	public static Coordinate fromBytes(byte[] bytes) throws IOException {
		Schema schema = SchemaRegistry.get().getUnchecked(FULL_NAME);
		GenericRecord grec = AvroUtils.deserialize(schema, bytes);
		return fromGenericRecord(grec);
	}

	@Override
	public CoordinateProto toProto() {
		return CoordinateProto.newBuilder()
									.setX(m_x)
									.setY(m_y)
									.build();
	}

	public static Coordinate fromProto(CoordinateProto proto) {
		return new Coordinate(proto.getX(), proto.getY());
	}
}

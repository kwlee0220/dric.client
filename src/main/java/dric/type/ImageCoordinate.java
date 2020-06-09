package dric.type;

import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;

import dric.proto.ImageCoordinateProto;
import dric.store.AvroUtils;
import dric.store.SchemaRegistry;


/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class ImageCoordinate implements AvroSerializable, PBSerializable<ImageCoordinateProto> {
	private static final String FULL_NAME = "dric.ImageCoordinate";
	private static Schema SCHEMA;
	
	private final int m_x;
	private final int m_y;
	
	public ImageCoordinate(int x, int y) {
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
	
	public int x() {
		return m_x;
	}
	
	public int y() {
		return m_y;
	}
	
	@Override
	public GenericRecord toGenericRecord() {
		GenericRecord grec = new GenericData.Record(schema());
		grec.put("x", m_x);
		grec.put("y", m_y);
		
		return grec;
	}

	public static ImageCoordinate fromGenericRecord(GenericRecord grec) {
		int x = (int)grec.get("x");
		int y = (int)grec.get("y");
		
		return new ImageCoordinate(x, y);
	}

	public static ImageCoordinate fromBytes(byte[] bytes) throws IOException {
		Schema schema = SchemaRegistry.get().getUnchecked(FULL_NAME);
		GenericRecord grec = AvroUtils.deserialize(schema, bytes);
		return fromGenericRecord(grec);
	}

	@Override
	public ImageCoordinateProto toProto() {
		return ImageCoordinateProto.newBuilder()
									.setX(m_x)
									.setY(m_y)
									.build();
	}

	public static ImageCoordinate fromProto(ImageCoordinateProto proto) {
		return new ImageCoordinate(proto.getX(), proto.getY());
	}
}

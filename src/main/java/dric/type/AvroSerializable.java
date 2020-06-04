package dric.type;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public interface AvroSerializable {
	public Schema schema();
	
	public GenericRecord toGenericRecord();
//	public static T fromGenericRecord(GenericRecord grecord);
	
	public default byte[] toBytes() throws IOException {
		ByteArrayOutputStream  out = new ByteArrayOutputStream();
		DatumWriter<GenericRecord> writer = new GenericDatumWriter<>(schema());
		Encoder encoder = EncoderFactory.get().binaryEncoder(out, null);
		writer.write(toGenericRecord(), encoder);
		encoder.flush();
		out.close();
		
		return out.toByteArray();
	}
}

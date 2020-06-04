package dric.store;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class AvroUtils {
	private AvroUtils() {
		throw new AssertionError("Should not be called: class=" + getClass());
	}
	
	public static byte[] serialize(Schema schema, GenericRecord data) throws IOException {
		ByteArrayOutputStream  out = new ByteArrayOutputStream();
		DatumWriter<GenericRecord> writer = new GenericDatumWriter<>(schema);
		Encoder encoder = EncoderFactory.get().binaryEncoder(out, null);
		writer.write(data, encoder);
		encoder.flush();
		out.close();
		
		return out.toByteArray();
	}
	
	public static GenericRecord deserialize(Schema schema, byte[] bytes) throws IOException {
		DatumReader<GenericRecord> reader = new GenericDatumReader<>(schema);
		Decoder decoder = DecoderFactory.get().binaryDecoder(bytes, null);
		return reader.read(null, decoder);
	}
}

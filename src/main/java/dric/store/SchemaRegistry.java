package dric.store;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.avro.Protocol;
import org.apache.avro.Schema;
import org.apache.avro.compiler.idl.Idl;
import org.apache.avro.compiler.idl.ParseException;

import com.google.common.collect.Maps;

import dric.type.SchemaNotFoundException;
import utils.func.FOption;
import utils.stream.FStream;


/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class SchemaRegistry {
	private static SchemaRegistry s_singleton;
	private final Map<String,Schema> m_schemas;
	
	static {
		try {
			s_singleton = new SchemaRegistry();
		}
		catch ( Exception e ) {
			e.printStackTrace(System.err);
		}
	}
	public static SchemaRegistry get() {
		return s_singleton;
	}
	
	private SchemaRegistry() throws ParseException, IOException {
		m_schemas = Maps.newHashMap();
		
		try ( Idl parser = new Idl(getClass().getResourceAsStream("dric_types.avdl")) ) {
			Protocol protocol = parser.CompilationUnit();
			FStream.from(protocol.getTypes())
					.forEach(this::register);
		}
	}
	
	public void loadFromIdl(File idlFile) throws IOException, ParseException {
		try ( Idl parser = new Idl(idlFile) ) {
			Protocol protocol = parser.CompilationUnit();
			FStream.from(protocol.getTypes())
					.forEach(this::register);
		}
	}
	
	public void register(Schema schema) {
		m_schemas.put(schema.getFullName(), schema);
	}
	
	public FOption<Schema> get(String fullName) {
		return FOption.ofNullable(m_schemas.get(fullName));
	}
	
	public Schema getUnchecked(String fullName) {
		Schema schema = m_schemas.get(fullName);
		if ( schema == null ) {
			throw new SchemaNotFoundException(fullName);
		}
		
		return schema;
	}
}

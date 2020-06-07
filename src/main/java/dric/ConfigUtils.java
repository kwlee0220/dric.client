package dric;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import com.google.common.collect.Lists;

import dric.proto.EndPoint;
import dric.proto.JdbcEndPoint;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import utils.NetUtils;
import utils.UnitUtils;
import utils.func.FOption;
import utils.func.Funcs;
import utils.jdbc.JdbcProcessor;
import utils.stream.FStream;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class ConfigUtils {
	private ConfigUtils() {
		throw new AssertionError("Should not be called: class=" + getClass());
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String,Object> readYaml(File configFile) throws FileNotFoundException, IOException {
		Yaml yaml = new Yaml();
		try ( FileReader reader = new FileReader(configFile) ) {
			return (Map<String,Object>)yaml.load(reader);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String,Object> getSubConfig(Map<String,Object> config, String name) {
		Map<String,Object> props = (Map<String,Object>)config.get(name);
		if ( props == null ) {
			throw new IllegalArgumentException("invalid sub-configration name: " + name);
		}
		
		return props;
	}
	
	public static ManagedChannel createGrpcChannel(EndPoint ep) {
		return ManagedChannelBuilder.forAddress(ep.getHost(), ep.getPort())
									.usePlaintext()
									.build();
	}
	
	@SuppressWarnings("unchecked")
	public static EndPoint parseEndPoint(Map<String,Object> parent, String key) {
		Object obj = parent.get(key);
		if ( obj == null ) {
			throw new IllegalArgumentException("unknown end-point: key=" + key);
		}
		
		Map<String,Object> props = (Map<String,Object>)obj;
		String host = Funcs.applyIfNotNull(props.get("host"), Object::toString, "localhost");
		if ( host.equals("localhost") || host.equals("127.0.0.1") ) {
			host = NetUtils.getLocalHostAddress();
		}
		int port = FOption.ofNullable(props.get("port"))
							.map(Object::toString)
							.map(Integer::parseInt)
							.getOrElse(-1);
		
		return EndPoint.newBuilder().setHost(host).setPort(port).build();
	}
	
	public static JdbcEndPoint parseJdbcEndPoint(Map<String,Object> config, String key) {
		Map<String,Object> props = getSubConfig(config, key);
		String host = Funcs.applyIfNotNull(props.get("host"), Object::toString, "localhost");
		if ( host.equals("localhost") || host.equals("127.0.0.1") ) {
			host = NetUtils.getLocalHostAddress();
		}
		return JdbcEndPoint.newBuilder()
							.setSystem(props.get("system").toString())
							.setHost(host)
							.setPort(Integer.parseInt(props.get("port").toString()))
							.setDbName(props.get("db_name").toString())
							.setUser(props.get("user").toString())
							.setPassword(props.get("password").toString())
							.build();
	}
	
	public static JdbcProcessor getJdbcProcessor(JdbcEndPoint jep) {
		return JdbcProcessor.create(jep.getSystem(), jep.getHost(), jep.getPort(), jep.getUser(),
									jep.getPassword(), jep.getDbName());
	}
	
	public static String parseString(Map<String,Object> config, String key) {
		Object value = config.get(key);
		if ( value == null ) {
			throw new IllegalArgumentException("invalid sub-configration name: " + key);
		}
		
		return value.toString();
	}
	
	public static float parseFloat(Map<String,Object> config, String key) {
		Object value = config.get(key);
		if ( value == null ) {
			throw new IllegalArgumentException("invalid sub-configration name: " + key);
		}
		
		return Float.parseFloat(value.toString());
	}
	
	public static long parseDuration(Map<String,Object> config, String key) {
		Object value = config.get(key);
		if ( value == null ) {
			throw new IllegalArgumentException("invalid sub-configration name: " + key);
		}
		
		return UnitUtils.parseDuration(value.toString());
	}
	
	@SuppressWarnings("unchecked")
	public static List<File> parseOpenCvDllFiles(Map<String,Object> config, String key) {
		Object prop = config.get(key);
		if ( prop == null ) {
			throw new IllegalArgumentException("invalid sub-configration name: " + key);
		}
		
		if ( prop instanceof List ) {
			return FStream.from((List<String>)prop).map(File::new).toList();
		}
		else {
			return Lists.newArrayList(new File(prop.toString()));
		}
	}
}

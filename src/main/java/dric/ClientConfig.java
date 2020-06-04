package dric;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import dric.proto.ServiceEndPoint;
import utils.func.FOption;
import utils.func.Funcs;
import utils.jdbc.JdbcProcessor;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class ClientConfig {
	private final PlatformConfig m_platformConfig;
	private final FOption<File> m_openCvDllFile;
	
	private ClientConfig(PlatformConfig platformConfig, FOption<File> openCvDllFile) {
		m_platformConfig = platformConfig;
		m_openCvDllFile = openCvDllFile;
	}
	
	public static ClientConfig from(File configFile) throws FileNotFoundException, IOException {
		Yaml yaml = new Yaml();
		try ( FileReader reader = new FileReader(configFile) ) {
			@SuppressWarnings("unchecked")
			Map<String,Object> props = (Map<String,Object>)yaml.load(reader);
			return ClientConfig.from(props);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static ClientConfig from(Map<String,Object> config) {
		PlatformConfig platformConfig = PlatformConfig.from(getSubConfig(config, "dric_platform"));
		File dllFile = Funcs.applyIfNotNull((String)config.get("opencv_dll"), File::new);

		return new ClientConfig(platformConfig, FOption.ofNullable(dllFile));
	}
	
	public ServiceEndPoint dricPlatformEndPoint() {
		return m_platformConfig.m_endPoint;
	}
	
	public FOption<File> openCvDllFile() {
		return m_openCvDllFile;
	}
	
	private static Map<String,Object> getSubConfig(Map<String,Object> config, String name) {
		Map<String,Object> props = (Map<String,Object>)config.get(name);
		if ( props == null ) {
			throw new IllegalArgumentException("invalid sub-configration name: " + name);
		}
		
		return props;
	}
	
	public static class MqttConfig {
		private final String m_brokerUrl;
		
		private MqttConfig(String brokerUrl) {
			m_brokerUrl = brokerUrl;
		}
		
		private static MqttConfig from(Map<String,Object> props) {
			return new MqttConfig(props.get("broker").toString());
		}
		
		public String brokerUrl() {
			return m_brokerUrl;
		}
	}

	public static class VideoServerConfig {
		private final String m_host;
		private final int m_port;
		
		private VideoServerConfig(String host, int height) {
			m_host = host;
			m_port = height;
		}
		
		private static VideoServerConfig from(Map<String,Object> props) {
			return new VideoServerConfig(props.get("host").toString(), (int)props.get("port"));
		}
		
		public String host() {
			return m_host;
		}
		
		public int port() {
			return m_port;
		}
	}
	
	public static class PlatformConfig {
		private final ServiceEndPoint m_endPoint;
		
		private PlatformConfig(ServiceEndPoint sep) {
			m_endPoint = sep;
		}
		
		public static PlatformConfig from(Map<String,Object> props) {
			return new PlatformConfig(parseEndPoint(props));
		}
		
		public ServiceEndPoint getServiceEndPoint() {
			return m_endPoint;
		}
	}

	public static class JdbcConfig {
		private final String m_system;
		private final String m_host;
		private final int m_port;
		private final String m_dbName;
		private final String m_user;
		private final String m_passwd;
		
		private JdbcConfig(String system, String host, int port, String dbName, String user, String passwd) {
			m_system = system;
			m_host = host;
			m_port = port;
			m_dbName = dbName;
			m_user = user;
			m_passwd = passwd;
		}
		
		@SuppressWarnings("unused")
		private static JdbcConfig from(Map<String,Object> props) {
			return new JdbcConfig((String)props.get("system"),
									(String)props.get("host"),
									(int)props.get("port"),
									(String)props.get("dbname"),
									(String)props.get("user"),
									(String)props.get("password"));
		}
		
		public JdbcProcessor getJdbcProcessor() {
			return JdbcProcessor.create(m_system, m_host, m_port, m_user, m_passwd, m_dbName);
		}
	}
	
	private static ServiceEndPoint parseEndPoint(Map<String,Object> props) {
		String host = Funcs.applyIfNotNull(props.get("host"), Object::toString, "localhost"); 
		int port = FOption.ofNullable(props.get("port"))
							.map(Object::toString)
							.map(Integer::parseInt)
							.getOrElse(-1);
		
		return ServiceEndPoint.newBuilder().setHost(host).setPort(port).build();
	}
}

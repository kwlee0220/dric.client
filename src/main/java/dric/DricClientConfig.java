package dric;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import utils.func.FOption;
import utils.func.Funcs;
import utils.jdbc.JdbcProcessor;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class DricClientConfig {
	private final MqttConfig m_mqttConfig;
	private final VideoServerConfig m_videoConfig;
	private final DataStoreConfig m_tailConfig;
	private final FOption<File> m_openCvDllFile;
	
	private DricClientConfig(MqttConfig mqttConfig, VideoServerConfig videoConfig,
								DataStoreConfig tailConfig, FOption<File> openCvDllFile) {
		m_mqttConfig = mqttConfig;
		m_videoConfig = videoConfig;
		m_tailConfig = tailConfig;
		m_openCvDllFile = openCvDllFile;
	}
	
	public static DricClientConfig from(File configFile) throws FileNotFoundException, IOException {
		Yaml yaml = new Yaml();
		try ( FileReader reader = new FileReader(configFile) ) {
			@SuppressWarnings("unchecked")
			Map<String,Object> props = (Map<String,Object>)yaml.load(reader);
			return DricClientConfig.from(props);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static DricClientConfig from(Map<String,Object> config) {
		MqttConfig cameraConfig = MqttConfig.from(getSubConfig(config, "mqtt"));
		VideoServerConfig videoServerConfig = VideoServerConfig.from(getSubConfig(config, "video_server"));
		DataStoreConfig dataStoreConfig = DataStoreConfig.from(getSubConfig(config, "dric_data"));
		File dllFile = Funcs.applyIfNotNull((String)config.get("opencv_dll"), File::new);

		return new DricClientConfig(cameraConfig, videoServerConfig, dataStoreConfig,
									FOption.ofNullable(dllFile));
	}
	
	public MqttConfig mqttConfig() {
		return m_mqttConfig;
	}
	
	public VideoServerConfig videoServerConfig() {
		return m_videoConfig;
	}
	
	public DataStoreConfig dataStoreConfig() {
		return m_tailConfig;
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

	public static class DataStoreConfig {
		private final String m_host;
		private final int m_port;
		
		private DataStoreConfig(String host, int height) {
			m_host = host;
			m_port = height;
		}
		
		private static DataStoreConfig from(Map<String,Object> props) {
			return new DataStoreConfig(props.get("host").toString(), (int)props.get("port"));
		}
		
		public String host() {
			return m_host;
		}
		
		public int port() {
			return m_port;
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
}

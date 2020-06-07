package dric;

import java.util.Map;

public class VideoServerConfig {
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
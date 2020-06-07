package dric.command;

import java.io.IOException;

import dric.DrICClient;
import dric.proto.EndPoint;
import picocli.CommandLine.Option;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class DrICClientLoader {
	private static final int DEFAULT_PLATFORM_PORT = 10703;
	
	private String m_host = "localhost";
	private int m_port = DEFAULT_PLATFORM_PORT;
	
	public DrICClient load() throws IOException {
		EndPoint ep = EndPoint.newBuilder()
							.setHost(m_host)
							.setPort(m_port)
							.build();
		return DrICClient.connect(ep);
	}

	@Option(names={"-h", "--host"}, paramLabel="ip_addr",
			description={"DrICPlatform host (default: localhost)"})
	public void setHost(String host) {
		m_host = host;
	}

	@Option(names={"-p", "--port"}, paramLabel="port_no",
			description={"DrICPlatform port (default: 10703)"})
	public void setPort(int port) {
		m_port = port;
	}
}

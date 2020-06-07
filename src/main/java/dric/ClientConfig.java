package dric;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import dric.proto.EndPoint;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class ClientConfig {
	private final EndPoint m_platformEp;
	
	private ClientConfig(EndPoint platformEp) {
		m_platformEp = platformEp;
	}
	
	public static ClientConfig from(File configFile) throws FileNotFoundException, IOException {
		Yaml yaml = new Yaml();
		try ( FileReader reader = new FileReader(configFile) ) {
			@SuppressWarnings("unchecked")
			Map<String,Object> props = (Map<String,Object>)yaml.load(reader);
			return ClientConfig.from(props);
		}
	}
	
	public static ClientConfig from(Map<String,Object> config) {
		EndPoint platformEp = ConfigUtils.parseEndPoint(config, "dric_platform");

		return new ClientConfig(platformEp);
	}
	
	public EndPoint platformEndPoint() {
		return m_platformEp;
	}
}

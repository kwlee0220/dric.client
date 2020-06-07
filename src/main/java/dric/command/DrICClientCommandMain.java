package dric.command;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Help;
import utils.func.FOption;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
@Command(name="dric_client",
			parameterListHeading = "Parameters:%n",
			optionListHeading = "Options:%n",
			description="DrIC client commands",
			subcommands = {
				VideoServerCommands.class,
			})
public class DrICClientCommandMain extends DrICClientCommand {
	private static final Logger s_logger = LoggerFactory.getLogger(DrICClientCommandMain.class);
	
	public static final void main(String... args) throws Exception {
		configureLog4j();

		DrICClientCommandMain cmd = new DrICClientCommandMain();
		CommandLine.run(cmd, System.out, System.err, Help.Ansi.OFF, args);
	}
	
	public static File getLog4jPropertiesFile() {
		String homeDir = FOption.ofNullable(System.getenv("DRIC_HOME"))
								.getOrElse(() -> System.getProperty("user.dir"));
		return new File(homeDir, "log4j.properties");
	}
	
	public static File configureLog4j() throws IOException {
		File propsFile = getLog4jPropertiesFile();
		
		Properties props = new Properties();
		try ( InputStream is = new FileInputStream(propsFile) ) {
			props.load(is);
		}
		PropertyConfigurator.configure(props);
		if ( s_logger.isDebugEnabled() ) {
			s_logger.debug("use log4j.properties from {}", propsFile);
		}
		
		return propsFile;
	}
	
//	private Server createServer(DrICVideoServerImpl server, int port) {
//		PBDrICVideoServerServant servant = new PBDrICVideoServerServant(server);
//		Server nettyServer = NettyServerBuilder.forPort(port)
//												.addService(servant)
//												.build();
//		return nettyServer;
//	}
}

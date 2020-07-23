package dric.command;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dric.DrICClient;
import picocli.CommandLine;
import picocli.CommandLine.Help.Ansi;
import picocli.CommandLine.Mixin;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Option;
import picocli.CommandLine.RunLast;
import picocli.CommandLine.Spec;
import utils.PicocliCommand;
import utils.Throwables;
import utils.UsageHelp;
import utils.Utilities;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class DrICClientCommand implements PicocliCommand<DrICClient> {
	private static final Logger s_logger = LoggerFactory.getLogger(DrICClientCommand.class);
	private static final String ENV_VAR_HOME = "DRIC_CLIENT_HOME";
	
	@Spec private CommandSpec m_spec;
	@Mixin private UsageHelp m_help;
	@Mixin private DrICClientLoader m_loader;

	@Option(names={"--home"}, paramLabel="path", description={"DrICClient Home Directory"})
	private File m_homeDir;
	
	@Option(names={"-v"}, description={"verbose"})
	private boolean m_verbose = false;
	
	private DrICClient m_client;

	public static final void run(DrICClientCommand cmd, String... args) throws Exception {
		new CommandLine(cmd).parseWithHandler(new RunLast(), System.err, args);
	}
	
	protected void run(DrICClient client) throws Exception {
		m_spec.commandLine().usage(System.out, Ansi.OFF);
	}
	
	@Override
	public DrICClient getInitialContext() {
		try {
			if ( m_client == null ) {
				m_client = m_loader.load();
			}
			
			return m_client;
		}
		catch ( IOException e ) {
			Throwables.sneakyThrow(e);
			throw new AssertionError();
		}
	}
	
	@Override
	public void run() {
		try {
			run(getInitialContext());
		}
		catch ( Exception e ) {
			System.err.printf("failed: %s%n%n", e);
		}
	}
	
	public void configureLog4j() throws IOException {
		File propsFile = new File(getHomeDir(), "log4j.properties");
		if ( m_verbose ) {
			System.out.println("use log4.properties=" + propsFile);
		}
		
		Properties props = new Properties();
		try ( InputStream is = new FileInputStream(propsFile) ) {
			props.load(is);
		}
		PropertyConfigurator.configure(props);
		if ( s_logger.isDebugEnabled() ) {
			s_logger.debug("use log4j.properties from {}", propsFile);
		}
	}
	
	private File getHomeDir() {
		File homeDir = m_homeDir;
		if ( homeDir == null ) {
			String homeDirPath = System.getenv(ENV_VAR_HOME);
			if ( homeDirPath == null ) {
				return Utilities.getCurrentWorkingDir();
			}
			else {
				return new File(homeDirPath);
			}
		}
		else {
			return m_homeDir;
		}
	}
}
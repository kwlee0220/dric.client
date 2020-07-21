package dric.command;

import java.io.IOException;

import dric.DrICClient;
import picocli.CommandLine.Help.Ansi;
import picocli.CommandLine.Mixin;
import picocli.CommandLine.Model.CommandSpec;
import picocli.CommandLine.Spec;
import utils.PicocliCommand;
import utils.Throwables;
import utils.UsageHelp;

/**
 * 
 * @author Kang-Woo Lee (ETRI)
 */
public class DrICClientCommand implements PicocliCommand<DrICClient> {
	@Spec private CommandSpec m_spec;
	@Mixin private UsageHelp m_help;
	@Mixin private DrICClientLoader m_loader;
	
	private DrICClient m_client;
	
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
			
//			m_spec.commandLine().usage(System.out, Ansi.OFF);
		}
	}

	@Override
	public void configureLog4j() throws IOException {
		// do nothing
	}
}
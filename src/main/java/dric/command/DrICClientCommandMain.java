package dric.command;

import picocli.CommandLine.Command;

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
	public static final void main(String... args) throws Exception {
		run(new DrICClientCommandMain(), args);
	}
}

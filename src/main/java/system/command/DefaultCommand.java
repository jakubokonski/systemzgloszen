package system.command;

import java.util.SortedMap;

public class DefaultCommand implements Command {

	private static class DefaultCommandSingleton {
		private static final DefaultCommand INSTANCE = new DefaultCommand();
	}

	public static DefaultCommand getInstance() {
		return DefaultCommandSingleton.INSTANCE;
	}

	@Override
	public void execute() {
		System.out.println("Method not found");
		ShowHelpCommand.getInstance().execute();
	}
}

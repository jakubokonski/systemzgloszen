package system.command;

public class SystemExitCommand implements Command {

	private static class SystemExitCommandSingleton {
		private static final SystemExitCommand INSTANCE =
			new SystemExitCommand();
	}

	public static SystemExitCommand getInstance() {
		return SystemExitCommandSingleton.INSTANCE;
	}

	private SystemExitCommand() {

	}

	@Override
	public void execute() {
		System.exit(0);
	}
}

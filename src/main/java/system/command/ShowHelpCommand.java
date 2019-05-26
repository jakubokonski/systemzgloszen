package system.command;

public class ShowHelpCommand implements Command {
	@Override
	public void execute() {
		System.out.println("1: Show All Issues");
		System.out.println("2: Show All Users");
		System.out.println("3: Add new Issue");
		System.out.println("4: Add new User");
		System.out.println("5: Modify description for issue");
		System.out.println("6: Assign user to issue");
		System.out.println("0: help");
		System.out.println("-1: Exit program");
	}

	private static class ShowHelpCommandSingleton {
		private static final ShowHelpCommand INSTANCE = new ShowHelpCommand();
	}

	public static ShowHelpCommand getInstance() {
		return ShowHelpCommandSingleton.INSTANCE;
	}
}

package system.command;

import system.IssueSystem;

public class ShowUsersCommand implements Command {
	private static class ShowUsersCommandSingleton {
		private static final ShowUsersCommand INSTANCE = new ShowUsersCommand();
	}

	public static ShowUsersCommand getInstance() {
		return ShowUsersCommandSingleton.INSTANCE;
	}

	private ShowUsersCommand() {

	}

	@Override
	public void execute() {
		IssueSystem.getInstance().getUserList()
			.forEach(p -> System.out.println(p));
	}
}

package system.command;

import system.IssueSystem;
import system.issue.Issue;

public class ShowIssuesCommand implements Command {

	private static class ShowIssuesCommandSingleton {
		private static final ShowIssuesCommand INSTANCE = new ShowIssuesCommand();
	}

	public static ShowIssuesCommand getInstance() {
		return ShowIssuesCommandSingleton.INSTANCE;
	}

	@Override
	public void execute() {
		IssueSystem.getInstance().getIssueList()
			.forEach(p -> System.out.println(p));
	}
}

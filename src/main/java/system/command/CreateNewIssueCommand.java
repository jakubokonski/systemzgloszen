package system.command;

import system.IssueSystem;
import system.MainClass;
import system.issue.Issue;
import system.issue.IssuePriority;
import system.issue.IssueType;

import java.util.Scanner;

public class CreateNewIssueCommand implements Command {

	private static class CreateNewIssueCommandSingleton {
		private static final CreateNewIssueCommand INSTANCE =
			new CreateNewIssueCommand();
	}

	public static CreateNewIssueCommand getInstance() {
		return CreateNewIssueCommandSingleton.INSTANCE;
	}

	@Override
	public void execute() {
		System.out.println("Tworzenie nowego zagadnienia:");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Podaj Tytuł:");
		String title = scanner.nextLine();
		System.out.println("Podaj opis");
		String description = scanner.nextLine();


		Issue.IssueBuilder builder = Issue.builder().
			title(title)
			.description(description)
			.type(IssueType.WORK)
			.priority(IssuePriority.HIGH)
			.assignUser(MainClass.loggedInUser)
			.creator(MainClass.loggedInUser);

		IssueSystem.getInstance()
			.createIssue(MainClass.loggedInUser, builder);

	}
}

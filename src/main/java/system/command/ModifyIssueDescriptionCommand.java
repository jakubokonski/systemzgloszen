package system.command;

import system.IssueSystem;
import system.issue.Issue;

import java.util.Optional;
import java.util.Scanner;

public class ModifyIssueDescriptionCommand implements Command {

	private static class ModifyIssueDescriptionCommandSingleton {
		private static final ModifyIssueDescriptionCommand INSTANCE =
			new ModifyIssueDescriptionCommand();
	}

	public static ModifyIssueDescriptionCommand getInstance() {
		return ModifyIssueDescriptionCommandSingleton.INSTANCE;
	}

	@Override
	public void execute() {
		System.out.println("Wprowadz id Issue które chcesz modyfikować");
		Scanner scanner = new Scanner(System.in);
		int issueToModifyId = scanner.nextInt();

		System.out.println("Wprowadz opis issue");
		String description = scanner.nextLine();

		Optional<Issue> first = IssueSystem.getInstance().getIssueList()
			.stream().filter(p -> issueToModifyId == p.getId())
			.findFirst();

		if(!first.isPresent()) {
			System.out.println("Nie znaleziono issue o podanym Id");
			return;
		}

		Issue issue = first.get();
		issue.changeDescription(description);
	}

}

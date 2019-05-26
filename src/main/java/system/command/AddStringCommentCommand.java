package system.command;

import system.IssueSystem;
import system.issue.Issue;

import java.util.Optional;
import java.util.Scanner;

public class AddStringCommentCommand implements Command {

    private static class Singleton {

    }
    @Override
    public void execute() {
        System.out.println("Dodawanie komentarza do issue");
        System.out.println("Podaj id isssue");
        Scanner scanner = new Scanner(System.in);
        int issueId = scanner.nextInt();

        Optional<Issue> first = IssueSystem.getInstance().getIssueList().stream()
                .filter(p -> p.getId() == issueId)
                .findFirst();


    }
}

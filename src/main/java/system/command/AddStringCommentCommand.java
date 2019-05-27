package system.command;

import system.IssueSystem;
import system.MainClass;
import system.comment.TextComment;
import system.issue.Issue;

import java.util.Optional;
import java.util.Scanner;

public class AddStringCommentCommand implements Command {

    private static class Singleton {
        private static final AddStringCommentCommand INSTANCE = new AddStringCommentCommand();
    }

    private AddStringCommentCommand() {

    }

    public static AddStringCommentCommand  getInstance() {
        return Singleton.INSTANCE;
    }
    @Override
    public void execute() {
        System.out.println("Dodawanie komentarza do issue");
        System.out.println("Podaj id isssue");
        Scanner scanner = new Scanner(System.in);
        int issueId = scanner.nextInt();

        Optional<Issue> first = IssueSystem.getInstance().getIssueList()
                .stream()
                .filter(p -> p.getId() == issueId)
                .findFirst();

        if (!first.isPresent()) {
            System.out.println("No issue found.");
            return;
        }
        System.out.println("Write comment:");
        scanner.next();
        String textContent = scanner.nextLine();
        Issue issue = first.get();
        issue.addComment(
                new TextComment(MainClass.loggedInUser, textContent)
        );

        System.out.println("Comment successfully added");
    }
}

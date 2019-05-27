package system.command;

import system.IssueSystem;
import system.issue.Issue;
import system.users.User;

import java.util.Optional;
import java.util.Scanner;

public class AssignOtherUserToIssueCommand implements Command {


    private static class Singleton {
        private static final AssignOtherUserToIssueCommand INSTANCE =
                new AssignOtherUserToIssueCommand();
    }

    private AssignOtherUserToIssueCommand() {

    }

    public static AssignOtherUserToIssueCommand getInstance() {
        return Singleton.INSTANCE;
    }

    @Override
    public void execute() {
        System.out.println("Assign User by Id to issue by id");
        System.out.println("Please enter user id");
        Scanner scanner = new Scanner(System.in);
        int userId = scanner.nextInt();

        Optional<User> user = IssueSystem.getInstance().getUserList()
                .stream()
                .filter(p -> p.getId() == userId)
                .findFirst();

        if(!user.isPresent()) {
            System.out.println("User with entered id not found");
            return;
        }

        System.out.println("Please enter issue id");
        int issueId = scanner.nextInt();
        Optional<Issue> issue = IssueSystem.getInstance().getIssueList()
                .stream()
                .filter(p -> p.getId() == issueId)
                .findFirst();

        if(!issue.isPresent()) {
            System.out.println("Issue with this id not found");
            return;
        }

        issue.get().setAssignUser(user.get());

    }
}


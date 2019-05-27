package system;

import system.command.factory.CommandFactory;
import system.command.Command;
import system.command.ShowHelpCommand;
import system.exporter.DefaultFileIssueExporter;
import system.exporter.ExporterFactory;
import system.issue.Issue;
import system.issue.IssuePriority;
import system.issue.IssueType;
import system.users.RoleType;
import system.users.SimplyUser;
import system.users.User;
import system.users.behaveImp.DefaultBehavior;

import java.io.File;
import java.util.Scanner;

public class MainClass {

    public static User loggedInUser;
    public static IssueSystem issueSystem;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Name:");
        String name = scanner.nextLine();
        System.out.println("Surname:");
        String surname = scanner.nextLine();

        loggedInUser = new SimplyUser(name, surname, RoleType.MOD, new DefaultBehavior());
        Issue issue = Issue.builder()
                .creator(loggedInUser)
                .assignUser(loggedInUser)
                .priority(IssuePriority.HIGH)
                .type(IssueType.ERROR)
                .description("Description")
                .title("Title")
                .build();

        IssueSystem.getInstance().getIssueList().add(issue);
        IssueSystem.getInstance().getUserList().add(loggedInUser);

        DefaultFileIssueExporter exporter = ExporterFactory.getExporter(Integer.valueOf(0).shortValue());
        File export = exporter.export(IssueSystem.getInstance().getIssueList());

        ShowHelpCommand.getInstance().execute();

        while (true) {
            int i = scanner.nextInt();
            Command command = CommandFactory.getCommand(i);
            command.execute();
        }
    }
}

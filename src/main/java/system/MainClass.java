package system;

import system.command.CommandFactory;
import system.command.Command;
import system.command.ShowHelpCommand;
import system.users.RoleType;
import system.users.SimplyUser;
import system.users.User;
import system.users.behaveImp.DefaultBehavior;

import java.util.Scanner;

public class MainClass {

    public static User loggedInUser;
    public static IssueSystem issueSystem;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String name;
        String surname;
        issueSystem = IssueSystem.getInstance();

        System.out.println("Name:");
        name = input.nextLine();
        System.out.println("Surname:");
        surname = input.nextLine();

        loggedInUser = new SimplyUser(name, surname, RoleType.MOD, new DefaultBehavior());
        issueSystem.userList.add(loggedInUser);

        ShowHelpCommand showHelpCommand = ShowHelpCommand.getInstance();
        showHelpCommand.getInstance().execute();


        while (true) {
            int i = input.nextInt();
            Command command = CommandFactory.getCommand(i);

        }
    }
}

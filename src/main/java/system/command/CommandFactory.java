package system.command;

import static system.MainClass.issueSystem;

public class CommandFactory implements Command {

    public static Command getCommand(int id) {
        switch (id) {
            case 1:
                return ShowIssuesCommand.getInstance();
            case 2:
                return ShowUsersCommand.getInstance();
            case 3:
                return CreateNewIssueCommand.getInstance();
            case 4:
                return CreateNewUserCommand.getInstance();
            case 5:
                return ModifyIssueDescriptionCommand.getInstance();
            case 6:
                return AssigneOtherUserToIssueCommand.getInstance();
            case 0:
                return ShowHelpCommand.getInstance();
            default:
                return ShowHelpCommand.getInstance();
        }
    }

    @Override
    public void execute() {

    }
}

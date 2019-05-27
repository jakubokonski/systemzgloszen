package system.command.factory;

import system.command.*;

public class CommandFactory {

    public static Command getCommand(int id) {
        switch (id) {
            case -1:
                return SystemExitCommand.getInstance();
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
                return AssignOtherUserToIssueCommand.getInstance();
            case 7:
                AddStringCommentCommand.getInstance();
            case 0:
                return ShowHelpCommand.getInstance();
            default:
                return ShowHelpCommand.getInstance();
        }
    }
}

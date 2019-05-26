package system;

import system.issue.Issue;
import system.users.RoleType;
import system.users.User;
import system.users.exceptions.WrongRoleException;

import java.util.ArrayList;
import java.util.List;

public class IssueSystem {

    private static class IssueSystemSingleton {
        private static IssueSystem INSTANCE = new IssueSystem();
    }

    List<User> userList;
    List<Issue> issueList;

    private IssueSystem() {
        this.issueList = new ArrayList<Issue>();
        this.userList = new ArrayList<User>();
    }

    /**
     * Metoda tworzaca zagadnienie na pds uzytkownika i buildera
     * @param user user creating issue
     * @param builder obiekt do zbudowania
     * @return
     */
    public boolean createIssue(User user, Issue.IssueBuilder builder) {
        boolean isCreated = false;
        builder.creator(user);
        if (user.getRole().getPermission() <= RoleType.USER.getPermission()) {
            isCreated = this.issueList.add(builder.build());
        } else {
            throw new WrongRoleException("Only User and higher privilage can create");
        }
        return isCreated;
    }

    public boolean createNewUser(User addedUser, User userToAdd) {
        boolean isUserAdded = false;
        if (addedUser.getRole().getPermission() <= RoleType.MOD.getPermission()) {
            isUserAdded = this.userList.add(userToAdd);
        } else {
            throw new WrongRoleException("Only User and higher " +
                    "privilage can create new Issue");
        }
        return isUserAdded;
    }

    public static IssueSystem getInstance() {
        return IssueSystemSingleton.INSTANCE;
    }

    public List<User> getUserList() {
        return userList;
    }

    public List<Issue> getIssueList() {
        return issueList;
    }
}

package system.users.behaveImp;

import system.issue.Issue;
import system.users.interfaces.UserBehavior;

public class DefaultBehavior implements UserBehavior<Issue> {

    public void doSomething(Issue obj) {
        System.out.println("Jestem DefaultBehavior");
    }
}

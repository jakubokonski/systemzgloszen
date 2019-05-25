package system.users.behaveImp;

import system.issue.Issue;
import system.users.interfaces.UserBehavior;

public class IssueCommentReader implements UserBehavior<Issue> {

    public void doSomething(Issue obj) {
        System.out.println("Jestem IssueReader");
        System.out.println(obj);
    }
}

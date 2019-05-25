package system.users;

import org.junit.Assert;
import org.junit.Test;
import system.issue.Issue;
import system.users.behaveImp.DefaultBehavior;
import system.users.behaveImp.IssueCommentReader;
import system.users.exceptions.WrongRoleException;

public class SimplyUserTest {

    @Test(expected = WrongRoleException.class)
    public void createSimplyWithAdminRole() {
        SimplyUser simplyUser = new SimplyUser("Janek", "Kowalski", RoleType.ADMIN, new DefaultBehavior());


        Assert.assertNull(simplyUser);
    }

    @Test
    public void createSimplyWithUserRole() {
        SimplyUser simplyUser = new SimplyUser("Janek", "Kowalski", RoleType.USER, new IssueCommentReader());

        Assert.assertNotNull(simplyUser);
        Issue issue = new Issue();
        simplyUser.behave(issue);
    }
}
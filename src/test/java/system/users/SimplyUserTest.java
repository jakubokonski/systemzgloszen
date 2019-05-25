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

        Issue newIssue = Issue.builder()
                .assignUser(simplyUser)
                .creator(simplyUser)
                .build();

        simplyUser.behave(newIssue);
        simplyUser.setBehavior(new DefaultBehavior());
        simplyUser.behave(newIssue);
    }

    @Test
    public void testId() {
        SimplyUser firstUser = new SimplyUser("Janek", "Kowalski", RoleType.USER, new IssueCommentReader());
        SimplyUser secondUser = new SimplyUser("Marek", "Kowalski", RoleType.USER, new IssueCommentReader());

        Assert.assertEquals(firstUser.getId(), 1);
        Assert.assertEquals(secondUser.getId(), 2);
        System.out.println("FirstUser ID: " + firstUser.getId());
        System.out.println("SecondUser ID: " + secondUser.getId());

    }
}
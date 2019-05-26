package system;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import system.IssueSystem;
import system.issue.Issue;
import system.observers.ObserverMethod;
import system.users.RoleType;
import system.users.SimplyUser;
import system.users.User;
import system.users.behaveImp.DefaultBehavior;
import system.users.behaveImp.IssueCommentReader;

public class IssueSystemTest {

    private User admin;
    private User mod;
    private User user;
    private User guest;

    private Issue issueOne;
    private Issue issueTwo;
    private Issue issueThree;

    @Before
    public void prepareUsers(){
        admin = new User("Janek", "Kowalski", RoleType.ADMIN, new DefaultBehavior()) {
            @Override
            public void notify(ObserverMethod p) {
                System.out.println("Powiadomienie admina");
                p.execute();
            }
        };
        mod = new SimplyUser("Marek", "Nowak", RoleType.MOD, new IssueCommentReader());
        user = new SimplyUser("Jurek", "Zawadzki", RoleType.USER, new DefaultBehavior());
        guest = new SimplyUser("Jurek", "Zawadzki", RoleType.GUEST, new DefaultBehavior());
    }

    @Test
    public void testIssueSystem() {
        IssueSystem instance = IssueSystem.getInstance();
        Assert.assertNotNull(instance.getUserList());
        Assert.assertNotNull(instance.getIssueList());
    }

    @Test
    public void roleTest() {
        RoleType admin = RoleType.ADMIN;
        Assert.assertEquals(admin.getRoleName(), "ADMIN");
    }

    @Test
    public void createUserByAdminTest() {
        IssueSystem instance = IssueSystem.getInstance();
        boolean isNewUserCreated = instance.createNewUser(admin, guest);
        Assert.assertTrue(isNewUserCreated);
    }

    @Test
    public void createUserByUser() {
        IssueSystem instance = IssueSystem.getInstance();
        boolean isNewUserCreated = instance.createNewUser(user, guest);
        Assert.assertTrue(isNewUserCreated);
    }
}

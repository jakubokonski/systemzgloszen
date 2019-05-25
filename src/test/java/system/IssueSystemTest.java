package system;

import org.junit.Assert;
import org.junit.Test;
import system.IssueSystem;
import system.users.RoleType;

public class IssueSystemTest {

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
}

package system;

import org.junit.Before;
import org.junit.Test;
import system.issue.Issue;
import system.issue.IssuePriority;
import system.issue.IssueType;
import system.users.RoleType;
import system.users.SimplyUser;
import system.users.behaveImp.DefaultBehavior;
import system.users.behaveImp.IssueCommentReader;

public class ObserverTests {

    private SimplyUser s1;
    private SimplyUser s2;
    private SimplyUser s3;

    private Issue issueOne;
    private Issue issueTwo;
    private Issue issueThree;

    @Before
    public void prepareUsers(){
        s1 = new SimplyUser("Janek", "Kowalski", RoleType.USER, new DefaultBehavior());
        s2 = new SimplyUser("Marek", "Nowak", RoleType.USER, new IssueCommentReader());
        s3 = new SimplyUser("Jurek", "Zawadzki", RoleType.USER, new DefaultBehavior());
    }

    @Before
    public void prepareIssues() {
        issueOne = Issue.builder()
                .assignUser(s3)
                .creator(s2)
                .description("opis")
                .priority(IssuePriority.HIGH)
                .title("Potrzebne")
                .type(IssueType.ERROR)
                .build();

        issueTwo = Issue.builder()
                .assignUser(s1)
                .creator(s2)
                .description("opis")
                .priority(IssuePriority.LOW)
                .title("Issue 2 Low Work")
                .type(IssueType.WORK)
                .build();

        issueThree = Issue.builder()
                .assignUser(s2)
                .creator(s1)
                .description("opis")
                .priority(IssuePriority.LOW)
                .title("Issue 3 Low Work")
                .type(IssueType.WORK)
                .build();
    }

    @Test
    public void checkObserver() {
        issueOne.assignToSubject(s1);
        issueOne.assignToSubject(s2);

        issueTwo.assignToSubject(s3);

        issueThree.assignToSubject(s2);
        issueThree.assignToSubject(s3);

        issueThree.changeDescription("Zmiana opisu Issue 3");
        issueOne.notifyObservers();
        issueTwo.notifyObservers();

        System.out.println("\n");

        issueThree.setAssignUser(s3);
    }
}

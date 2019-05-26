package system.issue;

import system.exceptions.MethodNotAllowedException;
import system.observers.Observer;
import system.users.User;

public class IssueWrapper extends Issue {

    private final Issue issue;

    public IssueWrapper(Issue issue) {
        super();
        this.issue = issue;
    }

    @Override
    public void changeDescription(String newDescription) {
        issue.changeDescription(newDescription);
    }

    @Override
    public void setAssignUser(User user) {
        issue.setAssignUser(user);
    }

    @Override
    public void publish() {
        throw new MethodNotAllowedException("Publish not allowed");
    }

    @Override
    public void assignToSubject(Observer o) {
        issue.assignToSubject(o);
    }

    @Override
    public void unassignFromSubject(Observer o) {
        issue.unassignFromSubject(o);
    }

    @Override
    public void notifyObservers() {
        throw new MethodNotAllowedException("Notify not allowed");
    }
}

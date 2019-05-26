package system.issue;

import system.comment.Comment;
import system.observers.Observer;
import system.observers.Publisher;
import system.observers.Subject;
import system.users.User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

public class Issue implements Publisher, Subject, Serializable {
    private static AtomicInteger idGenerator = new AtomicInteger();

    private final int id;
    private final String title;
    private String description;
    private final User creator;
    private User assignUser;
    private IssueType type;
    private IssuePriority priority;

    private List<Comment> commentList;

    private List<Observer> observerList; //Observer interface, to have users, admins, etc

    protected Issue() {
        id = -1;
        title = "";
        creator = null;
    }

    private Issue(IssueBuilder builder) {
        this.id = Issue.idGenerator.incrementAndGet();
        this.title = builder.title;
        this.description = builder.description;
        this.creator = builder.creator;
        this.assignUser = builder.assignUser;
        this.type = builder.type;
        this.priority = builder.priority;
        this.commentList = new ArrayList<>();
        this.observerList = new ArrayList<>();
    }

    public void changeDescription(String newDescription) {
        this.description = newDescription;
        this.publish();
    }

    public void setAssignUser(User user) {
        this.assignUser = user;
        Optional<Observer> foundObserver = this.observerList.stream()
                .filter(p -> p.equals(user))
                .findAny();
        Observer observer = foundObserver.orElse(p -> System.out.println("Observer not found"));

        observer.notify(() -> {
            System.out.println("Zostałeś przypisany do issue id = [" + this.id + "]");
            return new IssueWrapper(this);
        });
    }

    public int getId() {
        return id;
    }

    public static IssueBuilder builder() {
        return new IssueBuilder();
    }

    @Override
    public void publish() {
        System.out.println("Description has been modified");
        notifyObservers();
    }

    @Override
    public void assignToSubject(Observer o) {
        this.observerList.add(o);
    }

    @Override
    public void unassignFromSubject(Observer o) {
        this.observerList.remove(o);
    }

    @Override
    public void notifyObservers() {
        this.observerList.stream()
                .forEach(observer -> {
                    observer.notify(() -> {
                        System.out.println("Issue with title = [" + this.title + "] has changed");
                        return new IssueWrapper(this);
                    });
                });
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void addComment(Comment c) {
        commentList.add(c);
        publish();
    }

    public static class IssueBuilder {

        private String title;
        private String description;
        private User creator;
        private User assignUser;
        private IssueType type;
        private IssuePriority priority;

        public IssueBuilder() {

        }

        public IssueBuilder title(String title) {
            this.title = title;
            return this;
        }

        public IssueBuilder description(String description) {
            this.description = description;
            return this;
        }

        public IssueBuilder creator(User creator) {
            this.creator = creator;
            return this;
        }

        public IssueBuilder assignUser(User assignUser) {
            this.assignUser = assignUser;
            return this;
        }

        public IssueBuilder type(IssueType type) {
            this.type = type;
            return this;
        }

        public IssueBuilder priority(IssuePriority priority) {
            this.priority = priority;
            return this;
        }

        public Issue build() {
            return new Issue(this);
        }
    }
}

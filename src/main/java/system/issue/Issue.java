package system.issue;

import system.users.User;

import java.util.concurrent.atomic.AtomicInteger;

public class Issue {

    private static AtomicInteger idGenerator = new AtomicInteger();


    private final int id;
    private final String title;
    private String description;
    private final User creator;
    private User assignUser;
    private IssueType type;
    private IssuePriority priority;


    private Issue(IssueBuilder builder) {
        this.id = Issue.idGenerator.incrementAndGet();
        this.title = builder.title;
        this.description = builder.description;
        this.creator = builder.creator;
        this.assignUser = builder.assignUser;
        this.type = builder.type;
        this.priority = builder.priority;
    }

    public static IssueBuilder builder() {
        return new IssueBuilder();
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

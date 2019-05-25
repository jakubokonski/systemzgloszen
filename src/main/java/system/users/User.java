package system.users;

import system.issue.Issue;
import system.observers.Observer;
import system.users.interfaces.UserBehavior;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class User implements Observer {

    private static AtomicInteger idGenerator = new AtomicInteger();
//    private static Integer idGenerator = 0;

    private final int id;
    private final String name;
    private final String surname;
    private RoleType role;
    private UserBehavior<Issue> behavior;

    public User(String name, String surname, RoleType role, UserBehavior behavior) {
        this.id = User.idGenerator.incrementAndGet();
//        this.id = User.idGenerator;
//        User.idGenerator = User.idGenerator + 1;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.behavior = behavior;
    }

    public void behave(Issue issue) {
        behavior.doSomething(issue);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    public UserBehavior getBehavior() {
        return behavior;
    }

    public void setBehavior(UserBehavior behavior) {
        this.behavior = behavior;
    }
}

package system.users;

import com.sun.javafx.binding.StringFormatter;
import javafx.beans.binding.StringExpression;
import system.issue.Issue;
import system.observers.ObserverMethod;
import system.users.exceptions.WrongRoleException;
import system.users.interfaces.UserBehavior;

public class SimplyUser extends User<Issue> {

    public SimplyUser(String name, String surname, RoleType role, UserBehavior behavior) {
        super(name, surname, role, behavior);
        if (RoleType.ADMIN.equals(role)) {
            throw new WrongRoleException("Zła rola");
        }
    }

    @Override
    public void notify(ObserverMethod<Issue> p) {
        StringExpression msg =
        StringFormatter.format("User name = [%s] has been notified", this.getName());
        System.out.println(msg.getValue());
        Issue execute = p.execute();
    }
}

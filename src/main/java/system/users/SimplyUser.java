package system.users;

import system.users.exceptions.WrongRoleException;
import system.users.interfaces.UserBehavior;

public class SimplyUser extends User {

    public SimplyUser(String name, String surname, RoleType role, UserBehavior behavior) {
        super(name, surname, role, behavior);
        if (RoleType.ADMIN.equals(role)) {
            throw new WrongRoleException("Zła rola");
        }
    }
}

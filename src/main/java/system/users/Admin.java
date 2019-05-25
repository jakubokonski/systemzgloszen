package system.users;

import system.users.interfaces.UserBehavior;

public class Admin extends User {

    public Admin(String name, String surname, RoleType role, UserBehavior behavior) {
        super(name, surname, role, behavior);
    }
}

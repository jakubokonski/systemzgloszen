package system.users.exceptions;

public class WrongRoleException extends RuntimeException {
    public WrongRoleException(String message) {
        super(message);
    }
}

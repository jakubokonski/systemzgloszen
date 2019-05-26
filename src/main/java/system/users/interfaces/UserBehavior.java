package system.users.interfaces;

import java.io.Serializable;

public interface UserBehavior<T> extends Serializable {

    void doSomething(T obj);
}

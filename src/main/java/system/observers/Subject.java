package system.observers;

public interface Subject {
    void assignSubject(Observer o);
    void unassignFromSubject(Observer o);
    void notifyObservers();
}

package system.observers;

public interface Subject {
    void assignToSubject(Observer o);
    void unassignFromSubject(Observer o);
    void notifyObservers();
}

package model;

public interface Observable {
    void addObserver(Observer observer);
    void notifyObservers();
}

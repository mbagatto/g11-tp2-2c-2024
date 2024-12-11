package model;

public interface ObservableCard {
    void addObserver(ObserverCard observer);
    void notifyObservers();
}

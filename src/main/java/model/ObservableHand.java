package model;

public interface ObservableHand {
    void addObserver(HandObserver observer);
    void notifyObservers();
}

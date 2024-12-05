package model;

public interface ObservableRound {
    void addObserverRound(ObserverRound observerRound);
    void notifyObserversRound();
}

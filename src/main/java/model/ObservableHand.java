package model;

public interface ObservableHand {
    void addObserverHand(ObserverHand observer);

    void notifyObserversHand();
}
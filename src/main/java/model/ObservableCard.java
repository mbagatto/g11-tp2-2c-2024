package model;

public interface ObservableCard {
    void addObserver(CardObserver observer);
    void notifyObservers();
}

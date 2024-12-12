package model;

public interface ObservablePlayerDeck {
    void addObserver(PlayerDeckObserver observer);
    void notifyObservers();
}
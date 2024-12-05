package model;

public interface ObservablePlayerDeck {

    void addObserversPlayerDeck(ObserverPlayerDeck observerPlayerDeck);

    void notifyObserversPlayerDeck();
}
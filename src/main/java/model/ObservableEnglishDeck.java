package model;

public interface ObservableEnglishDeck {
    void addObserver(EnglishDeckObserver observer);
    void notifyObservers();
}

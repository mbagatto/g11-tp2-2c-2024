package model;

public interface ObservableRound {
    void addObserver(RoundObserver roundObserver);
    void notifyObservers();
}

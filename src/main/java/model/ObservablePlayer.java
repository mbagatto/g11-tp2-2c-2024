package model;

public interface ObservablePlayer {
    void addObserver(PlayerObserver observer);
    void notifyObservers();
}

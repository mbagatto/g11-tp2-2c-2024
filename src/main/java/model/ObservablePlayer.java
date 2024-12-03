package model;

public interface ObservablePlayer {

    void addObserverPlayer(ObserverPlayer observerPlayer);
    void notifyObserversPlayer();
}

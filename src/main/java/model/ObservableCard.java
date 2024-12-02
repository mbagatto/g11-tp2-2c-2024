package model;

import model.score.Score;

public interface ObservableCard {
    void attach(Observer observer);
    void detach(Observer observer);
    void notifyObservers();

    String getNumber();

    Score getPoints();

    Score getMultiplier();

    String getSuit();

}

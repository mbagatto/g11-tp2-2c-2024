package model;

import model.score.Score;

public interface ObservableCard {
    void attach(ObserverCard observer);
    void detach(ObserverCard observer);
    void notifyObservers();

    String getNumber();

    Score getPoints();

    Score getMultiplier();

    String getSuit();

}

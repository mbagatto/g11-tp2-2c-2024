package model;

import model.score.Score;

public interface Playable {
    int getNumber();
    Score getHands();
    Score getDiscards();
    Score getScoreToBeat();
}

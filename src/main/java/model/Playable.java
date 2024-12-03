package model;

import model.game.Store;
import model.score.Score;

public interface Playable {
    int getNumber();
    Score getHands();
    Score getDiscards();
    Score getScoreToBeat();
    Store getStore();
}

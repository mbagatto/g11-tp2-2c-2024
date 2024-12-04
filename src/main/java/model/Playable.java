package model;

import model.game.Shop;
import model.score.Score;

public interface Playable {
    int getNumber();
    Score getHands();
    Score getDiscards();
    Score getScoreToBeat();
    Shop getShop();
    Score getActualScore();
}

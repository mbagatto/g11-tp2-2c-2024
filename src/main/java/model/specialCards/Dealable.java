package model.specialCards;

import model.score.Score;

public class Dealable {
    Score score;

    public int calculateScore() {
        return this.score.calculateScore();
    }
}

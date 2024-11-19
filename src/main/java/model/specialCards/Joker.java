package model.specialCards;

import model.score.Score;

public class Joker extends Dealable {
    Score score;
    public Joker(Score score) {
        this.score = score;
    }
    public Score applyEffect(Score score) {
        score.addScore(this.score);
        return score;
    }
}

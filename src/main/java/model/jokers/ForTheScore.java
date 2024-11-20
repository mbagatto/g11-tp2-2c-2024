package model.jokers;

import model.hands.Hand;
import model.score.Score;

public class ForTheScore extends Effect {
    public ForTheScore(Score score) {
        super(score);
    }

    public void apply(Hand hand) {
        hand.addToScore(this.score);
    }
}

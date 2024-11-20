package model.jokers;

import model.hands.Hand;
import model.score.Score;

public class ForTheScore extends Joker {
    public ForTheScore(String name, Score score) {
        super(name, score);
    }

    public void applyEffect(Hand hand) {
        hand.addToScore(this.effect);
    }
}

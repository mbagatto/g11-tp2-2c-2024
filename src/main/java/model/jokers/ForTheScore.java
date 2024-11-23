package model.jokers;

import model.hands.Hand;
import model.score.Score;

public class ForTheScore extends Joker {

    public ForTheScore(String name, Score score) {
        super(name, score);
    }

    public ForTheScore(String name, String description, String activation, Score effect) {
        super(name, description, activation, effect);
    }

    public void applyEffect(Hand hand) {
        hand.addJokerScore(this.effect);
    }
}

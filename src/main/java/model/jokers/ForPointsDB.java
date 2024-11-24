package model.jokers;

import model.hands.Hand;
import model.score.Score;

public class ForPointsDB extends DiscardBonus {

    public ForPointsDB(String name, Score effect) {
        super(name, effect);
    }

    public ForPointsDB(String name, String description, String activation, Score effect) {
        super(name, description, activation, effect);
    }

    public void applyEffect(Hand hand) {
        if (this.discards > 0) {
            this.effect = new Score(this.effect.calculateScore() * this.discards);
            hand.addPoints(this.effect);
        }
    }
}

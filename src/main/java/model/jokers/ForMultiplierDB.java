package model.jokers;

import model.hands.Hand;
import model.score.Multiplier;
import model.score.Score;

public class ForMultiplierDB extends DiscardBonus {

    public ForMultiplierDB(String name, Score effect) {
        super(name, effect);
    }

    public void applyEffect(Hand hand) {
        if (this.discards > 0) {
            this.effect.changeMultiplier(new Multiplier(this.effect.calculateScore() * this.discards));
            hand.addJokerScore(this.effect);
        }
    }
}

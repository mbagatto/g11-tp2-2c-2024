package model.jokers;

import model.hands.Hand;
import model.score.Multiplier;
import model.score.Score;

public class DiscardBonusForMultiplier extends DiscardBonus {

    public DiscardBonusForMultiplier(String name, Score effect) {
        super(name, effect);
    }

    public void applyEffect(Hand hand) {
        if (this.discards > 0) {
            this.effect.changeMultiplier(new Multiplier(this.effect.calculateScore() * this.discards));
            hand.multiplyMultiplier(this.effect);
        }
    }
}

package model.jokers;

import model.hands.Hand;
import model.score.Score;

public class DiscardBonusForPoints extends DiscardBonus {

    public DiscardBonusForPoints(String name, Score effect) {
        super(name, effect);
    }

    public void applyEffect(Hand hand) {
        if (this.discards > 0) {
            this.effect = new Score(this.effect.calculateScore() * this.discards);
            hand.addPoints(this.effect);
        }
    }
}

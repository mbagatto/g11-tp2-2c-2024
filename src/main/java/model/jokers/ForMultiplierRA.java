package model.jokers;

import model.hands.Hand;
import model.score.Score;

public class ForMultiplierRA extends RandomActivation {

    public ForMultiplierRA(String name, Score effect, Probability probability) {
        super(name, effect, probability);
    }

    public void applyEffect(Hand hand) {
        if (this.probability.calculate()) {
            hand.addJokerScore(this.effect);
        }
    }
}

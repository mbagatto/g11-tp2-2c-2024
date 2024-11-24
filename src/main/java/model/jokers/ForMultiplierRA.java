package model.jokers;

import model.hands.Hand;
import model.score.Score;

public class ForMultiplierRA extends RandomActivation {

    public ForMultiplierRA(String name, Score effect, Probability probability) {
        super(name, effect, probability);
    }

    public ForMultiplierRA(String name, String description, String activation, Score effect) {
        super(name, description, activation, effect);
    }

    public void applyEffect(Hand hand) {
        if (this.probability.calculate()) {
            hand.addJokerScore(this.effect);
        }
    }
}

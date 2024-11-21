package model.jokers;

import model.hands.Hand;
import model.score.Score;

public class RandomActivationForPoints extends RandomActivation {

    public RandomActivationForPoints(String name, Score effect, Probability probability) {
        super(name, effect, probability);
    }

    public void applyEffect(Hand hand) {
        if (this.probability.calculate()) {
            hand.addPoints(this.effect);
        }
    }
}

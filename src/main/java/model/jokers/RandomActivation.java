package model.jokers;

import model.hands.Hand;
import model.score.Score;

public abstract class RandomActivation extends Joker {
    protected Probability probability;

    public RandomActivation(String name, Score effect, Probability probability) {
        super(name, effect);
        this.probability = probability;
    }

    public abstract void applyEffect(Hand hand);
}

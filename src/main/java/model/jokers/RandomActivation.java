package model.jokers;

import model.hands.Hand;
import model.score.DoNotModify;
import model.score.ScoreModifier;
import model.score.Score;

public class RandomActivation extends Joker {
    protected Probability probability;

    public RandomActivation(String name, String description, ScoreModifier toPoints, ScoreModifier toMultiplier, Probability probability) {
        super(name, description, toPoints, toMultiplier);
        this.probability = probability;
        this.type = "Random Activation";
    }

    public Score applyToPoints(Score points, Hand hand) {
        if (this.probability.calculate()) {
            return (this.toPoints.modify(points));
        }
        return new DoNotModify().modify(points);
    }

    public Score applyToMultiplier(Score multiplier, Hand hand) {
        if (this.probability.calculate()) {
            return (this.toMultiplier.modify(multiplier));
        }
        return new DoNotModify().modify(multiplier);
    }
}

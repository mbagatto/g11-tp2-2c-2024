package model.jokers;

import model.hands.Hand;
import model.score.ScoreModifier;
import model.score.Score;

public class ForTheScore extends Joker {
    public ForTheScore(String name, String description, ScoreModifier toPoints, ScoreModifier toMultiplier) {
        super(name, description, toPoints, toMultiplier);
    }

    public Score applyToPoints(Score points, Hand hand) {
        return (this.toPoints.modify(points));
    }

    public Score applyToMultiplier(Score multiplier, Hand hand) {
        return (this.toMultiplier.modify(multiplier));
    }
}

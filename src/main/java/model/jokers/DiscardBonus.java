package model.jokers;

import model.hands.Hand;
import model.score.Score;
import model.score.ScoreModifier;

public class DiscardBonus extends Joker {
    private Score discards;

    public DiscardBonus(Joker joker) {
        super(joker);
        this.type = "Discard Bonus";
    }

    public DiscardBonus(String name, String description, ScoreModifier toPoints, ScoreModifier toMultiplier) {
        super(name, description, toPoints, toMultiplier);
        this.discards = new Score(0);
        this.type = "Discard Bonus";
    }

    public void setDiscards(Score discards) {
        this.discards = discards;
    }

    public Score applyToPoints(Score points, Hand hand) {
        for (int i = 0; i < discards.numericValue(); i++) {
            points = this.toPoints.modify(points);
        }
        return points;
    }

    public Score applyToMultiplier(Score multiplier, Hand hand) {
        for (int i = 0; i < discards.numericValue(); i++) {
            multiplier = this.toMultiplier.modify(multiplier);
        }
        return multiplier;
    }
}

package model.jokers;

import model.hands.Hand;
import model.score.DoNotModify;
import model.score.Score;
import model.score.ScoreModifier;

public class DiscardBonus extends Joker {
    private int discards;

    public DiscardBonus(Joker joker) {
        super(joker);
    }

    public DiscardBonus(String name, ScoreModifier toPoints, ScoreModifier toMultiplier) {
        super(name, toPoints, toMultiplier);
        this.discards = 0;
    }

    public void incrementDiscards() {
        this.discards++;
    }

    public Score applyToPoints(Score points, Hand hand) {
        if (this.discards > 0) {
            for (int i = 0; i < discards; i++) {
                points = this.toPoints.modify(points);
            }
            return points;
        }
        return new DoNotModify().modify(points);
    }

    public Score applyToMultiplier(Score multiplier, Hand hand) {
        if (this.discards > 0) {
            for (int i = 0; i < discards; i++) {
                multiplier = this.toMultiplier.modify(multiplier);
            }
            return multiplier;
        }
        return new DoNotModify().modify(multiplier);
    }
}

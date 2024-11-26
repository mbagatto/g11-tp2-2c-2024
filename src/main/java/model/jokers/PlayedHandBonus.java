package model.jokers;

import model.hands.Hand;
import model.score.DoNotModify;
import model.score.ScoreModifier;
import model.score.Score;

public class PlayedHandBonus extends Joker {
    private final Hand hand;

    public PlayedHandBonus(String name, String description, ScoreModifier toPoints, ScoreModifier toMultiplier, Hand hand) {
        super(name, description, toPoints, toMultiplier);
        this.hand = hand;
    }

    public Score applyToPoints(Score points, Hand hand) {
        if (this.hand.equals(hand)) {
            return (this.toPoints.modify(points));
        }
        return new DoNotModify().modify(points);
    }

    public Score applyToMultiplier(Score multiplier, Hand hand) {
        if (this.hand.equals(hand)) {
            return (this.toMultiplier.modify(multiplier));
        }
        return new DoNotModify().modify(multiplier);
    }
}

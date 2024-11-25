package model.jokers;

import model.hands.Hand;
import model.score.ScoreModifier;
import model.score.Score;

public abstract class Joker {
    protected String name;
    protected ScoreModifier toPoints;
    protected ScoreModifier toMultiplier;

    public Joker(String name, ScoreModifier toPoints, ScoreModifier toMultiplier) {
        this.name = name;
        this.toPoints = toPoints;
        this.toMultiplier = toMultiplier;
    }

    public Joker(String name) {
        this.name = name;
    }

    public abstract Score applyToPoints(Score points, Hand hand);

    public abstract Score applyToMultiplier(Score multiplier, Hand hand);
}

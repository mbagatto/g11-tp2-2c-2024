package model.jokers;

import model.hands.Hand;
import model.score.ScoreModifier;
import model.score.Score;

public abstract class Joker {
    protected String name;
    protected ScoreModifier toPoints;
    protected ScoreModifier toMultiplier;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joker joker = (Joker) o;
        return name.equals(joker.name);
    }

    public Joker(Joker joker) {
        this.name = joker.name;
        this.toPoints = joker.toPoints;
        this.toMultiplier = joker.toMultiplier;
    }

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

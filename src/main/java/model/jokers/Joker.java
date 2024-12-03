package model.jokers;

import model.Purchasable;
import model.hands.Hand;
import model.reader.JokerData;
import model.score.ScoreModifier;
import model.score.Score;

public abstract class Joker implements Purchasable {
    protected String name;
    protected String description;
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
        this.description = joker.description;
        this.toPoints = joker.toPoints;
        this.toMultiplier = joker.toMultiplier;
    }

    public Joker(String name, String description, ScoreModifier toPoints, ScoreModifier toMultiplier) {
        this.name = name;
        this.description = description;
        this.toPoints = toPoints;
        this.toMultiplier = toMultiplier;
    }

    public Joker(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract Score applyToPoints(Score points, Hand hand);

    public abstract Score applyToMultiplier(Score multiplier, Hand hand);

    public boolean hasName(String aName) {
        return name.equals(aName);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String toString() {
        return "joker";
    }
}

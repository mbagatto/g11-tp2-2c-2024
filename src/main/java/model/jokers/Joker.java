package model.jokers;

import model.hands.Hand;
import model.score.ScoreModifier;
import model.score.Score;
import view.dtos.JokerDTO;

public abstract class Joker {
    protected String name;
    protected String description;
    protected ScoreModifier toPoints;
    protected ScoreModifier toMultiplier;
    protected String type;

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

    public Joker(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Joker(String name, String description, ScoreModifier toPoints, ScoreModifier toMultiplier) {
        this.name = name;
        this.description = description;
        this.toPoints = toPoints;
        this.toMultiplier = toMultiplier;
    }

    public abstract Score applyToPoints(Score points, Hand hand);

    public abstract Score applyToMultiplier(Score multiplier, Hand hand);

    public boolean hasName(String aName) {
        return name.equals(aName);
    }

    public boolean hasType(String aType) {
        return type.equals(aType);
    }

    public JokerDTO toDTO() {
        return new JokerDTO(this.name, this.description);
    }

    public void incrementDiscards() {
    }
}

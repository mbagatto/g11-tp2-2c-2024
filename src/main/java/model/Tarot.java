package model;

import model.score.ScoreModifier;

public class Tarot {
    private String name;
    private String description;
    private ScoreModifier toPoints;
    private ScoreModifier toMultiplier;
    private Modifiable target;

    public Tarot(String name, String description, ScoreModifier toPoints, ScoreModifier toMultiplier, Modifiable target) {
        this.name = name;
        this.description = description;
        this.toPoints = toPoints;
        this.toMultiplier = toMultiplier;
        this.target = target;
    }

    public void apply() {
        this.target.applyTarot(this.toPoints, this.toMultiplier);
    }
}

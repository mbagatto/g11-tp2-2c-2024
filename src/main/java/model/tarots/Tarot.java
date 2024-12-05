package model.tarots;

import model.Modifiable;
import model.Purchasable;
import model.cards.Card;
import model.score.ScoreModifier;

import java.util.ArrayList;

public class Tarot implements Purchasable {
    private String name;
    private String description;
    private ScoreModifier toPoints;
    private ScoreModifier toMultiplier;
    private Modifiable target;

    public Tarot(String name, String description, ScoreModifier toPoints, ScoreModifier toMultiplier) {
        this.name = name;
        this.description = description;
        this.toPoints = toPoints;
        this.toMultiplier = toMultiplier;
    }

    public void setTarget(Modifiable target) {
        this.target = target;
    }

    public boolean apply() {
        return this.target.applyTarot(this.toPoints, this.toMultiplier, this.target);
    }

    public boolean hasName(String name) {
        return this.name.equals(name);
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
        return "tarot";
    }
}

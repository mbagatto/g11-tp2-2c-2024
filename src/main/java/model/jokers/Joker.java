package model.jokers;

import model.hands.Hand;
import model.score.Score;

public abstract class Joker {
    protected String name;
    protected Score effect;
    protected String description;
    protected String activation;

    public Joker(String name, String description, String activation, Score effect) {
        this.name = name;
        this.description = description;
        this.activation = activation;
        this.effect = effect;
    }

    public Joker(String name, Score effect) {
        this.name = name;
        this.effect = effect;
    }

    public boolean isMyName(String name) {
        return name.equals(this.name);
    }

    public Joker(String name) {
        this.name = name;
    }

    public abstract void applyEffect(Hand hand);
}

package model.jokers;

import model.hands.Hand;
import model.score.Score;

public abstract class Joker {
    protected String name;
    protected Score effect;

    public Joker(String name, Score effect) {
        this.name = name;
        this.effect = effect;
    }

    public Joker(String name) {
        this.name = name;
    }

    public abstract void applyEffect(Hand hand);
}

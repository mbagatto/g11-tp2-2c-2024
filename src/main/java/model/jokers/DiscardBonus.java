package model.jokers;

import model.hands.Hand;
import model.score.Score;

public abstract class DiscardBonus extends Joker {
    protected int discards;

    public DiscardBonus(String name, Score effect) {
        super(name, effect);
        this.discards = 0;
    }

    public DiscardBonus(String name, String description, String activation, Score effect) {
        super(name, description, activation, effect);
    }

    public abstract void applyEffect(Hand hand);

    public void incrementDiscards() {
        this.discards++;
    }
}

package model.tarots;

import model.score.Score;

public class Tarot {
    protected String name;
    protected Score effect;

    public Tarot(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
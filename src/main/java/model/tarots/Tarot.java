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

    public boolean hasName(String aName) {
        return name.equals(aName);
    }
}
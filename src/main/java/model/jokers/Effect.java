package model.jokers;

import model.hands.Hand;
import model.score.Score;

public abstract class Effect {
    protected Score score;

    public Effect(Score score) {
        this.score = score;
    }

    abstract protected void apply(Hand hand);
}

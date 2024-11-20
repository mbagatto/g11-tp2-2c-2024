package model.jokers;

import model.hands.Hand;
import model.score.Score;

public abstract class Effect {
    protected Score score;

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Effect effect = (Effect) o;
//        return score.equals(effect.score);
//    }

    public Effect(Score score) {
        this.score = score;
    }

    abstract protected void apply(Hand hand);
}

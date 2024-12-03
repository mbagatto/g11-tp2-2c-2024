package model.hands;

import model.score.Score;

public class NullHand extends Hand {
    public NullHand() {
        this.name = "";
        this.points = new Score(0);
        this.multiplier = new Score(0);
    }
}

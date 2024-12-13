package model.hands;

import model.score.Score;

public class NullHand extends Hand {
    private static NullHand instance;

    private NullHand() {
        super(new Score(0), new Score(0));
        this.name = "";
    }

    public static NullHand getInstance() {
        if (instance == null) {
            instance = new NullHand();
        }
        return instance;
    }
}

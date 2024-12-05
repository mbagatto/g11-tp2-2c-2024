package model.hands;

import model.score.Score;

public class StraightFlush extends Hand {
    private static StraightFlush instance;

    private StraightFlush() {
        super(new Score(100), new Score(8));
        this.name = "Straight Flush";
    }

    public static StraightFlush getInstance() {
        if (instance == null) {
            instance = new StraightFlush();
        }
        return instance;
    }
}

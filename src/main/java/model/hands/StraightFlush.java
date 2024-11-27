package model.hands;

import model.score.Score;

public class StraightFlush extends Hand {
    private static StraightFlush instance;

    private StraightFlush() {
        this.name = "Straight Flush";
        this.points = new Score(100);
        this.multiplier = new Score(8);
    }

    public static StraightFlush getInstance() {
        if (instance == null) {
            instance = new StraightFlush();
        }
        return instance;
    }
}

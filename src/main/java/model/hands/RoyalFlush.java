package model.hands;

import model.score.Score;

public class RoyalFlush extends Hand {
    private static RoyalFlush instance;

    private RoyalFlush() {
        this.name = "Royal Flush";
        this.points = new Score(100);
        this.multiplier = new Score(8);
    }

    public static RoyalFlush getInstance() {
        if (instance == null) {
            instance = new RoyalFlush();
        }
        return instance;
    }
}

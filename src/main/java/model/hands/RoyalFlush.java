package model.hands;

import model.score.Score;

public class RoyalFlush extends Hand {
    private static RoyalFlush instance;

    private RoyalFlush() {
        super(new Score(100), new Score(8));
        this.name = "Royal Flush";
    }

    public static RoyalFlush getInstance() {
        if (instance == null) {
            instance = new RoyalFlush();
        }
        return instance;
    }
}

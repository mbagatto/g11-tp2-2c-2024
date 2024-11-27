package model.hands;

import model.score.Score;

public class Straight extends Hand {
    private static Straight instance;

    private Straight() {
        this.name = "Straight";
        this.points = new Score(30);
        this.multiplier = new Score(4);
    }

    public static Straight getInstance() {
        if (instance == null) {
            instance = new Straight();
        }
        return instance;
    }
}

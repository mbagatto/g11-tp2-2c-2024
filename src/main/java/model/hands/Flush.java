package model.hands;

import model.score.Score;

public class Flush extends Hand {
    private static Flush instance;

    private Flush() {
        this.name = "Flush";
        this.points = new Score(35);
        this.multiplier = new Score(4);
    }

    public static Flush getInstance() {
        if (instance == null) {
            instance = new Flush();
        }
        return instance;
    }
}

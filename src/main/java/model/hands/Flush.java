package model.hands;

import model.score.Score;

public class Flush extends Hand {
    private static Flush instance;

    private Flush() {
        super(new Score(35), new Score(4));
        this.name = "Color";
    }

    public static Flush getInstance() {
        if (instance == null) {
            instance = new Flush();
        }
        return instance;
    }
}

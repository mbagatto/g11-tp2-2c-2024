package model.hands;

import model.score.Score;

public class Straight extends Hand {
    private static Straight instance;

    private Straight() {
        super(new Score(30), new Score(4));
        this.name = "Escalera";
    }

    public static Straight getInstance() {
        if (instance == null) {
            instance = new Straight();
        }
        return instance;
    }
}

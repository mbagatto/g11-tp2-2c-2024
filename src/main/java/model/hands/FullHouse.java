package model.hands;

import model.score.Score;

public class FullHouse extends Hand {
    private static FullHouse instance;

    private FullHouse() {
        this.name = "Full House";
        this.points = new Score(40);
        this.multiplier = new Score(4);
    }

    public static FullHouse getInstance() {
        if (instance == null) {
            instance = new FullHouse();
        }
        return instance;
    }
}

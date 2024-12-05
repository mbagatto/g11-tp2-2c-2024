package model.hands;

import model.score.Score;

public class FullHouse extends Hand {
    private static FullHouse instance;

    private FullHouse() {
        super(new Score(40), new Score(4));
        this.name = "Full House";
    }

    public static FullHouse getInstance() {
        if (instance == null) {
            instance = new FullHouse();
        }
        return instance;
    }
}

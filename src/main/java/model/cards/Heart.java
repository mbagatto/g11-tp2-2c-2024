package model.cards;

import model.score.Score;

public class Heart extends Card {
    public Heart(String number, Score value, Score multiplier) {
        super(number, value, multiplier);
        this.suit = "Hearts";
    }
}

package model.cards;

import model.score.Score;

public class Club extends Card {
    public Club(String number, Score value, Score multiplier) {
        super(number, value, multiplier);
        this.suit = "Clubs";
    }
}

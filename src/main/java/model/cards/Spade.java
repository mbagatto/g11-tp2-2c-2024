package model.cards;

import model.score.Score;

public class Spade extends Card {
    public Spade(String number, Score value, Score multiplier) {
        super(number, value, multiplier);
        this.suit = "Spades";
    }
}

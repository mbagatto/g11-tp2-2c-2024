package model.cards;

import model.ObserverCard;
import model.score.Score;

import java.util.ArrayList;

public class Club extends Card {
    public Club(String number, Score value, Score multiplier) {
        super(number, value, multiplier);
        this.suit = "Clubs";
        this.observers = new ArrayList<>();
    }
}

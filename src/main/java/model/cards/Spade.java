package model.cards;

import model.ObserverCard;
import model.score.Score;

import java.util.ArrayList;

public class Spade extends Card {
    public Spade(String number, Score value, Score multiplier) {
        super(number, value, multiplier);
        this.suit = "Spades";
        this.observers = new ArrayList<>();
    }
}

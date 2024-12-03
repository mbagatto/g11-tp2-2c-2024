package model.cards;

import model.ObserverCard;
import model.score.Score;

import java.util.ArrayList;

public class Heart extends Card {
    public Heart(String number, Score value, Score multiplier) {
        super(number, value, multiplier);
        this.suit = "Hearts";
        this.observers = new ArrayList<>();
    }
}

package model.cards;

import model.score.Score;
import java.util.ArrayList;

public class Diamond extends Card {
    public Diamond(String number, Score value, Score multiplier) {
        super(number, value, multiplier);
        this.suit = "Diamonds";
        this.observers = new ArrayList<>();
    }
}

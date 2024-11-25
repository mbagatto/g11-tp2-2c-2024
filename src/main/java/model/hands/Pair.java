package model.hands;

import model.cards.Card;
import model.score.Score;
import java.util.ArrayList;

public class Pair extends Hand {
    public Pair(ArrayList<Card> cards) {
        super(cards);
        this.name = "Pair";
        this.points = new Score(10);
        this.multiplier = new Score(2);
    }
}

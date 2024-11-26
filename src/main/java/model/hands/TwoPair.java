package model.hands;

import model.cards.Card;
import model.score.Score;
import java.util.ArrayList;

public class TwoPair extends Hand {
    public TwoPair(ArrayList<Card> cards) {
        super(cards);
        this.name = "Two Pair";
        this.points = new Score(20);
        this.multiplier = new Score(2);
    }
}

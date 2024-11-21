package model.hands;

import model.cards.Card;
import model.score.Score;
import java.util.ArrayList;

public class Pair extends Hand {
    public Pair(ArrayList<Card> cards) {
        super(cards);
        this.score = new Score(10, 2);
    }
}

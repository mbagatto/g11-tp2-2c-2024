package model.hands;

import model.cards.Card;
import model.score.Score;
import java.util.ArrayList;

public class FourOfAKind extends Hand {
    public FourOfAKind(ArrayList<Card> cards) {
        super(cards);
        this.score = new Score(60, 7);
    }
}

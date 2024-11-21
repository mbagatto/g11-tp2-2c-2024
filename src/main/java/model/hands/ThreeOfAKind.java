package model.hands;

import model.cards.Card;
import model.score.Score;
import java.util.ArrayList;

public class ThreeOfAKind extends Hand {
    public ThreeOfAKind(ArrayList<Card> cards) {
        super(cards);
        this.score = new Score(30, 3);
    }
}

package model.hands;

import model.cards.Card;
import model.score.Score;
import java.util.ArrayList;

public class HighCard extends Hand {
    public HighCard(ArrayList<Card> cards) {
        super(cards);
        this.score = new Score(5, 1);
    }
}

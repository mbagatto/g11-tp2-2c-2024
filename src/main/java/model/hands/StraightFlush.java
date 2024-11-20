package model.hands;

import model.cards.Card;
import model.score.Score;

import java.util.ArrayList;

public class StraightFlush extends Hand {
    public StraightFlush(ArrayList<Card> cards) {
        super(cards);
        this.score = new Score(100, 8);
    }
}

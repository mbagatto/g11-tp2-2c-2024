package model.hands;

import model.cards.Card;
import model.score.Score;
import java.util.ArrayList;

public class RoyalFlush extends Hand {
    public RoyalFlush(ArrayList<Card> cards) {
        super(cards);
        this.name = "Royal Flush";
        this.points = new Score(100);
        this.multiplier = new Score(8);
    }
}

package model.hands;

import model.cards.Card;
import model.score.Score;
import java.util.ArrayList;

public class HighCard extends Hand {
    public HighCard(ArrayList<Card> cards) {
        super(cards);
        this.name = "High Card";
        this.points = new Score(5);
        this.multiplier = new Score(1);
    }
}

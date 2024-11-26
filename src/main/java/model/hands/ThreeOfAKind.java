package model.hands;

import model.cards.Card;
import model.score.Score;
import java.util.ArrayList;

public class ThreeOfAKind extends Hand {
    public ThreeOfAKind(ArrayList<Card> cards) {
        super(cards);
        this.name = "Three Of A Kind";
        this.points = new Score(30);
        this.multiplier = new Score(3);
    }
}

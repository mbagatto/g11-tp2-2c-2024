package model.hands;

import model.cards.Card;
import model.score.Score;
import java.util.ArrayList;

public class FourOfAKind extends Hand {
    public FourOfAKind(ArrayList<Card> cards) {
        super(cards);
        this.name = "Four Of A Kind";
        this.points = new Score(60);
        this.multiplier = new Score(7);
    }
}

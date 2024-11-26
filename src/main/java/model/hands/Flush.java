package model.hands;

import model.cards.Card;
import model.score.Score;
import java.util.ArrayList;

public class Flush extends Hand {
    public Flush(ArrayList<Card> cards) {
        super(cards);
        this.name = "Flush";
        this.points = new Score(35);
        this.multiplier = new Score(4);
    }
}

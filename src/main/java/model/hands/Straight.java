package model.hands;

import model.cards.Card;
import model.score.Score;
import java.util.ArrayList;

public class Straight extends Hand {
    public Straight(ArrayList<Card> cards) {
        super(cards);
        this.name = "Straight";
        this.points = new Score(30);
        this.multiplier = new Score(4);
    }
}

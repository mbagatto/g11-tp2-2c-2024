package model.hands;

import model.cards.Card;
import model.score.Score;
import java.util.ArrayList;

public class FullHouse extends Hand {
    public FullHouse(ArrayList<Card> cards) {
        super(cards);
        this.name = "Full House";
        this.points = new Score(40);
        this.multiplier = new Score(4);
    }
}

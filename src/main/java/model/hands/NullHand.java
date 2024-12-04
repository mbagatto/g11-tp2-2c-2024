package model.hands;

import model.cards.Card;
import model.identifiers.FrequencyChecker;
import model.score.Score;

import java.util.ArrayList;

public class NullHand extends Hand {
    private static NullHand instance;

    public NullHand() {
        this.name = "";
        this.points = new Score(0);
        this.multiplier = new Score(0);
    }

    public static NullHand getInstance() {
        if (instance == null) {
            instance = new NullHand();
        }
        return instance;
    }

    @Override
    protected ArrayList<Card> findHandCards(ArrayList<Card> cards) {
        return (new FrequencyChecker()).findHandCards(cards, 2);
    }
}

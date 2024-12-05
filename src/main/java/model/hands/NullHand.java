package model.hands;

import model.cards.Card;
import model.identifiers.FrequencyChecker;
import model.score.Score;

import java.util.ArrayList;

public class NullHand extends Hand {
    private static NullHand instance;

    private NullHand() {
        super(new Score(0), new Score(0));
        this.name = "";
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

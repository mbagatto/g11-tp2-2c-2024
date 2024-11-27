package model.hands;

import model.cards.Card;
import model.identifiers.FrequencyChecker;
import model.score.Score;

import java.util.ArrayList;

public class TwoPair extends Hand {
    private static TwoPair instance;

    private TwoPair() {
        this.name = "Two Pair";
        this.points = new Score(20);
        this.multiplier = new Score(2);
    }

    public static TwoPair getInstance() {
        if (instance == null) {
            instance = new TwoPair();
        }
        return instance;
    }

    @Override
    protected ArrayList<Card> findHandCards(ArrayList<Card> cards) {
        return (new FrequencyChecker()).findHandCards(cards, 2);
    }
}

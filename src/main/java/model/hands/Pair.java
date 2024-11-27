package model.hands;

import model.cards.Card;
import model.identifiers.FrequencyChecker;
import model.score.Score;

import java.util.ArrayList;

public class Pair extends Hand {
    private static Pair instance;

    private Pair() {
        this.name = "Pair";
        this.points = new Score(10);
        this.multiplier = new Score(2);
    }

    public static Pair getInstance() {
        if (instance == null) {
            instance = new Pair();
        }
        return instance;
    }

    @Override
    protected ArrayList<Card> findHandCards(ArrayList<Card> cards) {
        return (new FrequencyChecker()).findHandCards(cards, 2);
    }
}

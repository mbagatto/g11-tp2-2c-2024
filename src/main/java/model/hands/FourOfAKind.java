package model.hands;

import model.cards.Card;
import model.identifiers.FrequencyChecker;
import model.score.Score;

import java.util.ArrayList;

public class FourOfAKind extends Hand {
    private static FourOfAKind instance;

    private FourOfAKind() {
        this.name = "Four Of A Kind";
        this.points = new Score(60);
        this.multiplier = new Score(7);
    }

    public static FourOfAKind getInstance() {
        if (instance == null) {
            instance = new FourOfAKind();
        }
        return instance;
    }

    @Override
    protected ArrayList<Card> findHandCards(ArrayList<Card> cards) {
        return (new FrequencyChecker()).findHandCards(cards, 4);
    }
}

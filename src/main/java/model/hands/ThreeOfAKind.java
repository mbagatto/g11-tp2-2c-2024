package model.hands;

import model.cards.Card;
import model.identifiers.FrequencyChecker;
import model.score.Score;

import java.util.ArrayList;

public class ThreeOfAKind extends Hand {
    private static ThreeOfAKind instance;

    private ThreeOfAKind() {
        super(new Score(30), new Score(3));
        this.name = "Trio";
    }

    public static ThreeOfAKind getInstance() {
        if (instance == null) {
            instance = new ThreeOfAKind();
        }
        return instance;
    }

    @Override
    protected ArrayList<Card> findHandCards(ArrayList<Card> cards) {
        return (new FrequencyChecker()).findHandCards(cards, 3);
    }
}

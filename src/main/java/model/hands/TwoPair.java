package model.hands;

import model.cards.Card;
import model.identifiers.FrequencyChecker;
import model.score.Score;
import java.util.ArrayList;

public class TwoPair extends Hand {
    private static TwoPair instance;

    private TwoPair() {
        super(new Score(20), new Score(2));
        this.name = "Doble Par";
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

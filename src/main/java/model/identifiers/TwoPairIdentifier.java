package model.identifiers;

import model.hands.Hand;
import model.cards.Card;
import model.hands.TwoPair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class TwoPairIdentifier implements HandIdentifier {
    private HandIdentifier next;
    private FrequencyChecker checker;

    public TwoPairIdentifier(HandIdentifier next) {
        this.next = next;
        this.checker = new FrequencyChecker();
    }

    @Override
    public Hand identify(ArrayList<Card> cards) {
        if (isTwoPair(cards)) {
            return new TwoPair(findHandCards(cards));
        }
        return next.identify(cards);
    }

    private boolean isTwoPair(ArrayList<Card> cards) {
        return checker.isTwoPair(cards);
    }

    private ArrayList<Card> findHandCards(ArrayList<Card> cards) {
        ArrayList<Card> handCards = new ArrayList<>(cards);
        HashMap<String, Integer> map = checker.generateMap(handCards);
        for (String key : map.keySet()) {
            if (map.get(key) != 2) {
                handCards.removeIf(card -> Objects.equals(card.getNumber(), key));
            }
        }
        return handCards;
    }
}

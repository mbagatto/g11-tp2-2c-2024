package model.identifiers;

import model.Hand;
import model.cards.Card;

import java.util.ArrayList;
import java.util.HashMap;

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
            return new Hand(20, 2, findHandCards(cards));
        }
        return next.identify(cards);
    }

    private boolean isTwoPair(ArrayList<Card> cards) {
        return checker.isTwoPair(cards);
    }

    private ArrayList<Card> findHandCards(ArrayList<Card> cards) {
        ArrayList<Card> handCards = new ArrayList<>(cards);
        HashMap<Integer, Integer> map = checker.generateMap(handCards);
        for (int key : map.keySet()) {
            if (map.get(key) != 2) {
                handCards.removeIf(card -> card.getValue() == key);
            }
        }
        return handCards;
    }
}

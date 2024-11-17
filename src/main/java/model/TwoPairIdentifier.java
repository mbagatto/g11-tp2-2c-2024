package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TwoPairIdentifier implements HandIdentifier {
    private HandIdentifier next;

    public TwoPairIdentifier(HandIdentifier next) {
        this.next = next;
    }

    @Override
    public Hand identify(ArrayList<Card> cards) {
        if (isTwoPair(cards)) {
            return new Hand(20, 2, findHandCards(cards));
        }
        return next.identify(cards);
    }

    private boolean isTwoPair(ArrayList<Card> cards) {
        ArrayList<Card> cardsCopy = new ArrayList<>(cards);
        Map<Integer, Integer> counters = generateMap(cardsCopy);

        int pairsCount = 0;
        for (int key : counters.keySet()) {
            if (counters.get(key) == 2) {
                pairsCount++;
            }
        }
        return pairsCount == 2;
    }

    private ArrayList<Card> findHandCards(ArrayList<Card> cards) {
        ArrayList<Card> handCards = new ArrayList<>(cards);
        HashMap<Integer, Integer> map = generateMap(handCards);
        for (int key : map.keySet()) {
            if (map.get(key) != 2) {
                handCards.removeIf(card -> card.getValue() == key);
            }
        }
        return handCards;
    }

    private HashMap<Integer, Integer> generateMap(ArrayList<Card> cards) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Card card : cards) {
            int value = card.getValue();
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        return map;
    }
}

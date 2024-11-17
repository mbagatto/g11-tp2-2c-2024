package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ThreeOfAKindIdentifier implements HandIdentifier {
    private HandIdentifier next;

    public ThreeOfAKindIdentifier(HandIdentifier next) {
        this.next = next;
    }

    @Override
    public Hand identify(ArrayList<Card> cards) {
        if (isThreeOfAKind(cards)) {
            return new Hand(30, 3, findHandCards(cards));
        }
        return next.identify(cards);
    }

    private boolean isThreeOfAKind(ArrayList<Card> cards) {
        ArrayList<Card> cardsCopy = new ArrayList<>(cards);
        Map<Integer, Integer> counters = generateMap(cardsCopy);

        boolean isThreeOfAKind = false;
        for (int key : counters.keySet()) {
            if (counters.get(key) == 3) {
                isThreeOfAKind = true;
            }
        }
        return isThreeOfAKind;
    }

    private ArrayList<Card> findHandCards(ArrayList<Card> cards) {
        ArrayList<Card> handCards = new ArrayList<>(cards);
        HashMap<Integer, Integer> map = generateMap(handCards);
        for (int key : map.keySet()) {
            if (map.get(key) != 3) {
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

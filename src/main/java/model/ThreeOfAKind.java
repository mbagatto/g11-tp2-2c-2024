package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ThreeOfAKind implements HandPattern {
    @Override
    public Hand verifyPattern(ArrayList<Card> cards) {
        ArrayList<Card> cardsCopy = new ArrayList<>(cards);
        Map<Integer, Integer> counters = new HashMap<>();

        for (Card card : cardsCopy) {
            int value = card.getValue();
            counters.put(value, counters.getOrDefault(value, 0) + 1);
        }

        boolean isThreeOfAKind = false;
        for (int key : counters.keySet()) {
            if (counters.get(key) == 3) {
                isThreeOfAKind = true;
            } else {
                cardsCopy.removeIf(card -> card.getValue() == key);
            }
        }

        if (isThreeOfAKind) {
            return (new Hand(30, 3, cardsCopy));
        }

        return null;
    }
}

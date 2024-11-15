package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FourOfAKind implements HandPattern {
    @Override
    public Hand verifyPattern(ArrayList<Card> cards) {
        ArrayList<Card> cardsCopy = new ArrayList<>(cards);
        Map<Integer, Integer> counters = new HashMap<>();

        for (Card card : cardsCopy) {
            int value = card.getValue();
            counters.put(value, counters.getOrDefault(value, 0) + 1);
        }

        boolean isFourOfAKind = false;
        for (int key : counters.keySet()) {
            if (counters.get(key) == 4) {
                isFourOfAKind = true;
            } else {
                cardsCopy.removeIf(card -> card.getValue() == key);
            }
        }

        if (isFourOfAKind) {
            return (new Hand(60, 7, cardsCopy));
        }

        return null;
    }
}

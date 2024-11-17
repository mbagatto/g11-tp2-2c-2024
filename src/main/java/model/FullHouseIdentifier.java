package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FullHouseIdentifier implements HandIdentifier {
    private HandIdentifier next;

    public FullHouseIdentifier(HandIdentifier next) {
        this.next = next;
    }

    @Override
    public Hand identify(ArrayList<Card> cards) {
        if (isFullHouse(cards)) {
            return new Hand(40, 4, cards);
        }
        return next.identify(cards);
    }

    private boolean isFullHouse(ArrayList<Card> cards) {
        ArrayList<Card> cardsCopy = new ArrayList<>(cards);
        Map<Integer, Integer> counters = new HashMap<>();

        for (Card card : cardsCopy) {
            int value = card.getValue();
            counters.put(value, counters.getOrDefault(value, 0) + 1);
        }

        boolean isThreeOfAKind = false;
        boolean isPair = false;
        for (int key : counters.keySet()) {
            if (counters.get(key) == 3) {
                isThreeOfAKind = true;
            }
            if (counters.get(key) == 2) {
                isPair = true;
            }
        }
        return (isThreeOfAKind && isPair);
    }
}

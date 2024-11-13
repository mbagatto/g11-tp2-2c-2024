import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pair implements HandPattern {
    @Override
    public Hand verifyPattern(ArrayList<Card> cards) {
        ArrayList<Card> cardsCopy = new ArrayList<>(cards);
        Map<Integer, Integer> counters = new HashMap<>();

        boolean patternFound = false;
        for (Card card : cardsCopy) {
            int value = card.getValue();
            counters.put(value, counters.getOrDefault(value, 0) + 1);
        }

        for (int key : counters.keySet()) {
            if (counters.get(key) == 2) {
                patternFound = true;
            } else {
                cardsCopy.removeIf(card -> card.getValue() == key);
            }
        }

        if (patternFound) {
            return (new Hand(10, 2, cardsCopy));
        }

        return null;
    }
}

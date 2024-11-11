import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DoublePair implements HandPattern {
    @Override
    public boolean verifyPattern(ArrayList<Card> cards) {
        Map<Integer, Integer> counters = new HashMap<>();

        for (Card card : cards) {
            int value = card.getValue();
            counters.put(value, counters.getOrDefault(value, 0) + 1);
        }

        int pairsCount = 0;
        for (int key : counters.keySet()) {
            if (counters.get(key) == 2) {
                pairsCount++;
            }
        }
        return (pairsCount == 2);
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ThreeOfAKind implements HandPattern {
    @Override
    public boolean verifyPattern(ArrayList<Card> cards) {
        Map<Integer, Integer> counters = new HashMap<>();

        for (Card card : cards) {
            int value = card.getValue();
            counters.put(value, counters.getOrDefault(value, 0) + 1);
        }

        for (int key : counters.keySet()) {
            if (counters.get(key) == 3) {
                return true;
            }
        }
        return false;
    }
}

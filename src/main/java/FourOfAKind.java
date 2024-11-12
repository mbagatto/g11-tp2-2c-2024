import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FourOfAKind implements HandPattern {
    @Override
    public Hand verifyPattern(ArrayList<Card> cards) {
        Map<Integer, Integer> counters = new HashMap<>();

        for (Card card : cards) {
            int value = card.getValue();
            counters.put(value, counters.getOrDefault(value, 0) + 1);
        }

        for (int key : counters.keySet()) {
            if (counters.get(key) == 4) {
                return (new Hand(60, 7));
            }
        }
        return null;
    }
}

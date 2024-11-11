import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FullHouse implements HandPattern {
    @Override
    public boolean verifyPattern(ArrayList<Card> cards) {
        Map<Integer, Integer> counters = new HashMap<>();

        for (Card card : cards) {
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

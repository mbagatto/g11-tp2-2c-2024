import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DoublePair implements HandPattern {
    @Override
    public Hand verifyPattern(ArrayList<Card> cards) {
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
        if (pairsCount == 2) {
            return this.findCards(cards);
        }
        return null;
    }

    private Hand findCards(ArrayList<Card> cards){
        Hand hand = new Hand(20, 2);
        Map<Integer, ArrayList<Card>> map = new HashMap<>();

        for (int i = 2; i <= 14; i++) {
            ArrayList<Card> cardsCopy = new ArrayList<>();
            for (Card card : cards) {
                if (card.getValue() == i) {
                    cardsCopy.add(card);
                }
            }
            map.put(i, cardsCopy);
        }

        for (Map.Entry<Integer, ArrayList<Card>> entry : map.entrySet()) {
            if (entry.getValue().size() == 2) {
                hand.addCard(entry.getValue().get(0));
                hand.addCard(entry.getValue().get(1));
            }
        }

        return hand;
    }

}

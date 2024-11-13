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

//    private Hand findCards(ArrayList<Card> cards){
//        Hand hand = new Hand(60, 7);
//        Map<Integer, ArrayList<Card>> map = new HashMap<>();
//
//        for (int i = 2; i < 14; i++) {
//            ArrayList<Card> cardsCopy = new ArrayList<>();
//            for (Card card : cards) {
//                if (card.getValue() == i) {
//                    cardsCopy.add(card);
//                }
//            }
//            map.put(i, cardsCopy);
//        }
//
//        for (Map.Entry<Integer, ArrayList<Card>> entry : map.entrySet()) {
//            if (entry.getValue().size() == 4) {
//                hand.addCard(entry.getValue().get(0));
//                hand.addCard(entry.getValue().get(1));
//                hand.addCard(entry.getValue().get(2));
//                hand.addCard(entry.getValue().get(3));
//            }
//        }
//
//        return hand;
//    }

}

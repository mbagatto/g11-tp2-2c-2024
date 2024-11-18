package model;

import java.util.*;

public class PairIdentifier implements HandIdentifier {
    private HandIdentifier next;

    public PairIdentifier(HandIdentifier next) {
        this.next = next;
    }

    @Override
    public Hand identify(ArrayList<Card> cards) {
        if (isPair(cards)) {
            return new Hand(10, 2, findHandCards(cards));
        }
        return new Hand(5, 1, findHighestCard(cards));
    }

    private boolean isPair(ArrayList<Card> cards) {
        ArrayList<Card> cardsCopy = new ArrayList<>(cards);
        Map<Integer, Integer> counters = generateMap(cardsCopy);

        boolean matches = false;
        for (int key : counters.keySet()) {
            if (counters.get(key) == 2) {
                matches = true;
            }
        }
        return matches;
    }

    private ArrayList<Card> findHandCards(ArrayList<Card> cards) {
        ArrayList<Card> handCards = new ArrayList<>(cards);
        HashMap<Integer, Integer> map = generateMap(handCards);
        for (int key : map.keySet()) {
            if (map.get(key) != 2) {
                handCards.removeIf(card -> card.getValue() == key);
            }
        }
        return handCards;
    }

    private HashMap<Integer, Integer> generateMap(ArrayList<Card> cards) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Card card : cards) {
            int value = card.getValue();
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        return map;
    }

    private ArrayList<Card> findHighestCard(ArrayList<Card> cards) {
        ArrayList<Card> cardsCopy = new ArrayList<>(cards);

        cardsCopy.sort(Comparator.comparingInt(Card::getValue));
        Card maxCard = cardsCopy.getLast();
        return new ArrayList<>(Arrays.asList(maxCard));
    }
}

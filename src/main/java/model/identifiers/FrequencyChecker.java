package model.identifiers;

import model.cards.Card;
import java.util.ArrayList;
import java.util.HashMap;

public class FrequencyChecker {
    public boolean hasPairs(ArrayList<Card> cards, int pairs) {
        HashMap<String, Integer> map = generateFrequenciesMap(cards);
        int counter = 0;
        for (String key : map.keySet()) {
            if (map.get(key) == 2) {
                counter++;
            }
        }
        return counter == pairs;
    }

    public boolean hasAppearances(ArrayList<Card> cards, int appearances) {
        HashMap<String, Integer> map = generateFrequenciesMap(cards);
        for (String key : map.keySet()) {
            if (map.get(key) == appearances) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Card> findHandCards(ArrayList<Card> cards, int value) {
        ArrayList<Card> handCards = new ArrayList<>(cards);
        HashMap<String, Integer> map = generateFrequenciesMap(cards);
        for (String key : map.keySet()) {
            if (map.get(key) != value) {
                handCards.removeIf(card -> card.isNumber(key));
            }
        }
        return handCards;
    }

    private HashMap<String, Integer> generateFrequenciesMap(ArrayList<Card> cards) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("2", 0);
        map.put("3", 0);
        map.put("4", 0);
        map.put("5", 0);
        map.put("6", 0);
        map.put("7", 0);
        map.put("8", 0);
        map.put("9", 0);
        map.put("10", 0);
        map.put("Jota", 0);
        map.put("Reina", 0);
        map.put("Rey", 0);
        map.put("As", 0);
        for (String key : map.keySet()) {
            for (Card card : cards) {
                if (card.isNumber(key)) {
                    map.put(key, map.get(key) + 1);
                }
            }
        }
        return map;
    }
}

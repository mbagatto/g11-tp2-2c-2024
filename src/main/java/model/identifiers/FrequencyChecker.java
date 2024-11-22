package model.identifiers;

import model.cards.Card;
import java.util.ArrayList;
import java.util.HashMap;

public class FrequencyChecker {

    public boolean hasPairs(ArrayList<Card> cards, int pairs) {
        HashMap<String, Integer> map = generateMap(cards);
        int counter = 0;
        for (String key : map.keySet()) {
            if (map.get(key) == 2) {
                counter++;
            }
        }
        return counter == pairs;
    }

    public boolean hasAppearances(ArrayList<Card> cards, int appearances) {
        HashMap<String, Integer> map = generateMap(cards);
        for (String key : map.keySet()) {
            if (map.get(key) == appearances) {
                return true;
            }
        }
        return false;
    }

    public HashMap<String, Integer> generateMap(ArrayList<Card> cards) {
        HashMap<String, Integer> map = new HashMap<>();
        for (Card card : cards) {
            String value = card.getNumber();
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        return map;
    }
}

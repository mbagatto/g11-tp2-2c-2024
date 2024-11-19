package model;

import model.Cards.Card;

import java.util.ArrayList;
import java.util.HashMap;

public class FrequencyChecker {
    public boolean isPair(ArrayList<Card> cards) {
        return hasPairs(cards, 1);
    }

    public boolean isTwoPair(ArrayList<Card> cards) {
        return hasPairs(cards, 2);
    }

    public boolean isThreeOfAKind(ArrayList<Card> cards) {
        return hasAppearances(cards, 3);
    }

    public boolean isFullHouse(ArrayList<Card> cards) {
        return isThreeOfAKind(cards) && isPair(cards);
    }

    public boolean isFourOfAKind(ArrayList<Card> cards) {
        return hasAppearances(cards, 4);
    }

    private boolean hasPairs(ArrayList<Card> cards, int pairs) {
        HashMap<Integer, Integer> map = generateMap(cards);
        int counter = 0;
        for (int key : map.keySet()) {
            if (map.get(key) == 2) {
                counter++;
            }
        }
        return counter == pairs;
    }

    private boolean hasAppearances(ArrayList<Card> cards, int appearances) {
        HashMap<Integer, Integer> map = generateMap(cards);
        for (int key : map.keySet()) {
            if (map.get(key) == appearances) {
                return true;
            }
        }
        return false;
    }

    public HashMap<Integer, Integer> generateMap(ArrayList<Card> cards) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Card card : cards) {
            int value = card.getValue();
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        return map;
    }
}

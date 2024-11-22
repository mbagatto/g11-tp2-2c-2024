package model.identifiers;

import model.cards.Card;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class SequenceChecker {
    private static Map<String, Integer> cardValues = createCardValues();

    public boolean isStraight(ArrayList<Card> cards) {
        ArrayList<Card> cardsCopy = new ArrayList<>(cards);
        ArrayList<Card> sortedCards = this.sortCards(cardsCopy);

        for (int i = 1; i < sortedCards.size(); i++) {
            int currentValue = cardValues.get(sortedCards.get(i).getNumber());
            int previousValue = cardValues.get(sortedCards.get(i - 1).getNumber());
            if (currentValue != previousValue + 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isFlush(ArrayList<Card> cards) {
        Card firstCard = cards.getFirst();
        for (Card card : cards) {
            if (!firstCard.hasSameSuitAs(card)) {
                return false;
            }
        }
        return true;
    }

    public boolean isStraightFlush(ArrayList<Card> cards) {
        return isStraight(cards) && isFlush(cards);
    }

    public boolean isRoyalFlush(ArrayList<Card> cards) {
        ArrayList<Card> cardsCopy = new ArrayList<>(cards);
        ArrayList<Card> sortedCards = this.sortCards(cardsCopy);

        if (!"10".equals(sortedCards.getFirst().getNumber())) {
            return false;
        }
        return isStraightFlush(sortedCards);
    }

    private ArrayList<Card> sortCards(ArrayList<Card> cards) {
        ArrayList<String> baseOrder = new ArrayList<>(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "Jota", "Reina", "Rey", "As"));
        ArrayList<Card> orderedCards = new ArrayList<>();
        Map<String, Card> positionMap = new LinkedHashMap<>();

        for (String numberCard : baseOrder) {
              positionMap.put(numberCard, null);
        }
        for (Card card : cards) {
            positionMap.replace(card.getNumber(), card);
        }
        for (Map.Entry<String, Card> entry : positionMap.entrySet()) {
            if(entry.getValue() != null){
                orderedCards.add(entry.getValue());
            }
        }
        return orderedCards;
    }

    private static Map<String, Integer> createCardValues() {
        Map<String, Integer> cardValues = new LinkedHashMap<>();
        cardValues.put("2", 2);
        cardValues.put("3", 3);
        cardValues.put("4", 4);
        cardValues.put("5", 5);
        cardValues.put("6", 6);
        cardValues.put("7", 7);
        cardValues.put("8", 8);
        cardValues.put("9", 9);
        cardValues.put("10", 10);
        cardValues.put("Jota", 11);
        cardValues.put("Reina", 12);
        cardValues.put("Rey", 13);
        cardValues.put("As", 14);
        return cardValues;
    }
}

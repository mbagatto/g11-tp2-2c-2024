package model.identifiers;

import model.cards.Card;

import java.util.*;

public class SequenceChecker {
    public boolean isStraight(ArrayList<Card> cards) {
        ArrayList<Card> cardsCopy = this.sortCards(cards);
        Map<String, Integer> cardValues = new HashMap<>();
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

        for (int i = 1; i < cardsCopy.size(); i++) {

            int currentValue = cardValues.get(cardsCopy.get(i).getNumber());
            int previousValue = cardValues.get(cardsCopy.get(i - 1).getNumber());

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
        ArrayList<Card> cardsCopy = this.sortCards(cards);

        if (!Objects.equals(cards.getFirst().getNumber(), "10")) {
            return false;
        }
        return isStraight(cardsCopy) && isFlush(cardsCopy);
    }

    public ArrayList<Card> sortCards(ArrayList<Card> cards) {
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

}

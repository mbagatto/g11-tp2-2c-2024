package model;

import java.util.ArrayList;
import java.util.Comparator;


public class Straight implements HandPattern {
    @Override
    public Hand verifyPattern(ArrayList<Card> cards) {
        ArrayList<Card> cardsCopy = new ArrayList<>(cards);
        cardsCopy.sort(Comparator.comparingInt(Card::getValue));

        for (int i = 1; i < cardsCopy.size(); i++) {
            if (cardsCopy.get(i).getValue() != cardsCopy.get(i - 1).getValue() + 1) {
                return null;
            }
        }

        return new Hand(30, 4, cardsCopy);
    }
}

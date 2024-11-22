package model.identifiers;

import model.cards.Card;
import model.hands.Hand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public abstract class FrequencyHandIdentifier implements HandIdentifier {
    protected HandIdentifier next;
    protected FrequencyChecker checker;

    public FrequencyHandIdentifier(HandIdentifier next) {
        this.next = next;
        this.checker = new FrequencyChecker();
    }

    public Hand identify(ArrayList<Card> cards) {
        return identifyHand(cards);
    }

    protected abstract Hand identifyHand(ArrayList<Card> cards);

    protected ArrayList<Card> findHandCards(ArrayList<Card> cards, int value) {
        ArrayList<Card> handCards = new ArrayList<>(cards);
        HashMap<String, Integer> map = checker.generateMap(handCards);
        for (String key : map.keySet()) {
            if (map.get(key) != value) {
                handCards.removeIf(card -> Objects.equals(card.getNumber(), key));
            }
        }
        return handCards;
    }
}

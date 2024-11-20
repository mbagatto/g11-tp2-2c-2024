package model.identifiers;

import model.hands.Hand;
import model.cards.Card;
import model.hands.ThreeOfAKind;
import model.score.Score;

import java.util.ArrayList;
import java.util.HashMap;

public class ThreeOfAKindIdentifier implements HandIdentifier {
    private HandIdentifier next;
    private FrequencyChecker checker;

    public ThreeOfAKindIdentifier(HandIdentifier next) {
        this.next = next;
        this.checker = new FrequencyChecker();
    }

    @Override
    public Hand identify(ArrayList<Card> cards) {
        if (isThreeOfAKind(cards)) {
            return new ThreeOfAKind(findHandCards(cards));
        }
        return next.identify(cards);
    }

    private boolean isThreeOfAKind(ArrayList<Card> cards) {
        return checker.isThreeOfAKind(cards);
    }

    private ArrayList<Card> findHandCards(ArrayList<Card> cards) {
        ArrayList<Card> handCards = new ArrayList<>(cards);
        HashMap<Integer, Integer> map = checker.generateMap(handCards);
        for (int key : map.keySet()) {
            if (map.get(key) != 3) {
                handCards.removeIf(card -> card.getValue() == key);
            }
        }
        return handCards;
    }
}

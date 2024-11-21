package model.identifiers;

import model.hands.Hand;
import model.cards.Card;
import model.hands.Pair;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class PairIdentifier implements HandIdentifier {
    private HandIdentifier next;
    private FrequencyChecker checker;

    public PairIdentifier(HandIdentifier next) {
        this.next = next;
        this.checker = new FrequencyChecker();
    }

    @Override
    public Hand identify(ArrayList<Card> cards) {
        if (isPair(cards)) {
            return new Pair(findHandCards(cards));
        }
        return next.identify(cards);
    }

    private boolean isPair(ArrayList<Card> cards) {
        return checker.isPair(cards);
    }

    private ArrayList<Card> findHandCards(ArrayList<Card> cards) {
        ArrayList<Card> handCards = new ArrayList<>(cards);
        HashMap<String, Integer> map = checker.generateMap(handCards);
        for (String key : map.keySet()) {
            if (map.get(key) != 2) {
                handCards.removeIf(card -> Objects.equals(card.getNumber(), key));
            }
        }
        return handCards;
    }
}

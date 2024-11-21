package model.identifiers;

import model.hands.FourOfAKind;
import model.hands.Hand;
import model.cards.Card;
import model.score.Score;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class FourOfAKindIdentifier implements HandIdentifier {
    private HandIdentifier next;
    private FrequencyChecker checker;

    public FourOfAKindIdentifier(HandIdentifier next) {
        this.next = next;
        this.checker = new FrequencyChecker();
    }

    @Override
    public Hand identify(ArrayList<Card> cards) {
        if (isFourOfAKind(cards)) {
            return new FourOfAKind(findHandCards(cards));
        }
        return next.identify(cards);
    }

    private boolean isFourOfAKind(ArrayList<Card> cards) {
        return checker.isFourOfAKind(cards);
    }

    private ArrayList<Card> findHandCards(ArrayList<Card> cards) {
        ArrayList<Card> handCards = new ArrayList<>(cards);
        HashMap<String, Integer> map = checker.generateMap(handCards);
        for (String key : map.keySet()) {
            if (map.get(key) != 4) {
                handCards.removeIf(card -> Objects.equals(card.getNumber(), key));
            }
        }
        return handCards;
    }
}

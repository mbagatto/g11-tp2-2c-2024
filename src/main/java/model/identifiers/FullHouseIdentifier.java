package model.identifiers;

import model.hands.FullHouse;
import model.hands.Hand;
import model.cards.Card;

import java.util.ArrayList;

public class FullHouseIdentifier implements HandIdentifier {
    private HandIdentifier next;
    private FrequencyChecker checker;

    public FullHouseIdentifier(HandIdentifier next) {
        this.next = next;
        this.checker = new FrequencyChecker();
    }

    @Override
    public Hand identify(ArrayList<Card> cards) {
        if (cards.size() < 5) { return next.identify(cards); }
        if (isFullHouse(cards)) {
            return new FullHouse(cards);
        }
        return next.identify(cards);
    }

    private boolean isFullHouse(ArrayList<Card> cards) {
        return checker.isFullHouse(cards);
    }
}

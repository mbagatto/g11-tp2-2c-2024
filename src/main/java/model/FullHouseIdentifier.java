package model;

import model.Cards.Card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FullHouseIdentifier implements HandIdentifier {
    private HandIdentifier next;
    private FrequencyChecker checker;

    public FullHouseIdentifier(HandIdentifier next) {
        this.next = next;
        this.checker = new FrequencyChecker();
    }

    @Override
    public Hand identify(ArrayList<Card> cards) {
        if (isFullHouse(cards)) {
            return new Hand(40, 4, cards);
        }
        return next.identify(cards);
    }

    private boolean isFullHouse(ArrayList<Card> cards) {
        return checker.isFullHouse(cards);
    }
}

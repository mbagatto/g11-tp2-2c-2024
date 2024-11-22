package model.identifiers;

import model.hands.FullHouse;
import model.hands.Hand;
import model.cards.Card;

import java.util.ArrayList;

public class FullHouseIdentifier extends FrequencyHandIdentifier {

    public FullHouseIdentifier(HandIdentifier next) {
        super(next);
    }

    @Override
    protected Hand identifyHand(ArrayList<Card> cards) {
        if (checker.hasAppearances(cards, 3) && checker.hasPairs(cards, 1)) {
            return new FullHouse(cards);
        }
        return next.identify(cards);
    }
}

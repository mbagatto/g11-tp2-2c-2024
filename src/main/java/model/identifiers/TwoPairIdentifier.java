package model.identifiers;

import model.hands.Hand;
import model.cards.Card;
import model.hands.TwoPair;
import java.util.ArrayList;

public class TwoPairIdentifier extends FrequencyHandIdentifier {

    public TwoPairIdentifier(HandIdentifier next) {
        super(next);
    }

    @Override
    protected Hand identifyHand(ArrayList<Card> cards) {
        if (checker.hasPairs(cards, 2)) {
            return new TwoPair(findHandCards(cards, 2));
        }
        return next.identify(cards);
    }
}

package model.identifiers;

import model.hands.Hand;
import model.cards.Card;
import model.hands.Pair;
import java.util.ArrayList;

public class PairIdentifier extends FrequencyHandIdentifier {

    public PairIdentifier(HandIdentifier next) {
        super(next);
    }

    @Override
    protected Hand identifyHand(ArrayList<Card> cards) {
        if (checker.hasPairs(cards, 1)) {
            return new Pair(findHandCards(cards, 2));
        }
        return next.identify(cards);
    }
}

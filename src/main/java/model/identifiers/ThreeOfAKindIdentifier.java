package model.identifiers;

import model.hands.Hand;
import model.cards.Card;
import model.hands.ThreeOfAKind;
import java.util.ArrayList;

public class ThreeOfAKindIdentifier extends FrequencyHandIdentifier {

    public ThreeOfAKindIdentifier(HandIdentifier next) {
        super(next);
    }

    @Override
    protected Hand identifyHand(ArrayList<Card> cards) {
        if (checker.hasAppearances(cards, 3)) {
            return new ThreeOfAKind(findHandCards(cards, 3));
        }
        return next.identify(cards);
    }
}

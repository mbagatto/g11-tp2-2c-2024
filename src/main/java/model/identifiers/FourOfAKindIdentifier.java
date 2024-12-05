package model.identifiers;

import model.hands.FourOfAKind;
import model.hands.Hand;
import model.cards.Card;
import java.util.ArrayList;

public class FourOfAKindIdentifier extends FrequencyHandIdentifier {

    public FourOfAKindIdentifier(HandIdentifier next) {
        super(next);
    }

    @Override
    protected Hand identifyHand(ArrayList<Card> cards) {
        if (checker.hasAppearances(cards, 4)) {
            return FourOfAKind.getInstance();
        }
        return next.identify(cards);
    }
}

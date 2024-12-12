package model.identifiers;

import model.cards.Card;
import model.hands.Hand;
import model.hands.NullHand;
import java.util.ArrayList;

public class NullHandIdentifier implements HandIdentifier {
    @Override
    public Hand identify(ArrayList<Card> cards) {
        return NullHand.getInstance();
    }
}

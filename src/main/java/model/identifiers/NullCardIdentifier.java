package model.identifiers;

import model.cards.Card;
import model.hands.Hand;
import model.hands.NullHand;
import java.util.ArrayList;

public class NullCardIdentifier implements HandIdentifier {
    @Override
    public Hand identify(ArrayList<Card> cards) {
        if (cards.isEmpty()){
            return NullHand.getInstance();
        }
        return null;
    }
}

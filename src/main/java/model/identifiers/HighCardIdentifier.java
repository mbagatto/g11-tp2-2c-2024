package model.identifiers;

import model.hands.Hand;
import model.cards.Card;
import model.hands.HighCard;
import java.util.ArrayList;

public class HighCardIdentifier implements HandIdentifier {
    @Override
    public Hand identify(ArrayList<Card> cards) {
        return HighCard.getInstance();
    }
}

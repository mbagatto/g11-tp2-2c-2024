package model.identifiers;

import model.hands.Hand;
import model.cards.Card;
import model.hands.HighCard;
import java.util.ArrayList;

public class HighCardIdentifier implements HandIdentifier  {
    private NullCardIdentifier nullCardIdentifier;

    public HighCardIdentifier(HandIdentifier next) {
        this.nullCardIdentifier = new NullCardIdentifier();
    }

    @Override
    public Hand identify(ArrayList<Card> cards) {
        if (cards.isEmpty()) {
            return this.nullCardIdentifier.identify(cards);
        }
        return HighCard.getInstance();
    }
}

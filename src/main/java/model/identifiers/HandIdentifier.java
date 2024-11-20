package model.identifiers;

import model.hands.Hand;
import model.cards.Card;

import java.util.ArrayList;

public interface HandIdentifier {
    Hand identify(ArrayList<Card> cards);
}

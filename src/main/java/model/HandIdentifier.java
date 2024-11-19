package model;

import model.Cards.Card;

import java.util.ArrayList;

public interface HandIdentifier {
    Hand identify(ArrayList<Card> cards);
}

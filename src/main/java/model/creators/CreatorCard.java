package model.creators;

import model.cards.Card;

public interface CreatorCard {
    Card createCard(String suit, String name, String number, int value, int multiplier);
}

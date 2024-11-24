package model.cards;

public interface CreatorCard {
    Card createCard(String suit, String name, String number, int value, int multiplier);
}

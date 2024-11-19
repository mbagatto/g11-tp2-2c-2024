package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {
    @Test
    public void test01DealMustThrowAnExceptionWhenIsEmpty() {
        Deck deck = new Deck();
        assertThrows(EmptyDeckException.class, deck::deal);
    }

    @Test
    public void test02ADeckThatDealtACardIsNotEqualToAFullDeck() {
        // Arrange
        Deck deck = new Deck();
        deck.fillDeck();
        Deck otherDeck = new Deck();
        otherDeck.fillDeck();
        // Act
        deck.deal();
        // Assert
        assertNotEquals(deck, otherDeck);
    }
}
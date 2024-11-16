package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {
    @Test
    public void dealMustThrowsAnExceptionWhenIsEmpty() {
        Deck deck = new Deck();
        assertThrows(EmptyDeckException.class, deck::deal);
    }

    @Test
    public void verifyThatDeckCardsAreCorrectlyDecreasedAfterDealing() {
        Deck deck = new Deck();
        deck.fillDeck();

        Deck otherDeck = new Deck();
        otherDeck.fillDeck();

        for (int i = 1; i <= 5; i++) {
            deck.deal();
        }

        assertNotEquals(deck, otherDeck);
    }
}
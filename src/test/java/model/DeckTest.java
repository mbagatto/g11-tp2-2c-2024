package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeckTest {
    @Test
    public void verifyThatDeckHas52Cards() {
        Deck deck = new Deck();
        assertTrue(deck.isReadyToPlay());
    }

    @Test
    public void verifyThatDeckCardsAreCorrectlyDecreasedAfterDealing() {
        Deck deck = new Deck();
        for (int i = 1; i <= 5; i++) {
            deck.deal();
        }
        int expectedResult = 47;
        assertTrue(deck.hasAmount(expectedResult));
    }
}
package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnglishDeckTest {
    @Test
    public void dealMustThrowsAnExceptionWhenIsEmpty() {
        EnglishDeck englishDeck = new EnglishDeck();
        assertThrows(EmptyDeckException.class, englishDeck::deal);
    }

    @Test
    public void verifyThatDeckCardsAreCorrectlyDecreasedAfterDealing() { // Este test deberiamos borrarlo porque no testea funcionalidad. Y no existe un test distinto que lo reemplace
        EnglishDeck englishDeck = new EnglishDeck();
        englishDeck.fillDeck();

        EnglishDeck otherEnglishDeck = new EnglishDeck();
        otherEnglishDeck.fillDeck();

        for (int i = 1; i <= 5; i++) {
            englishDeck.deal();
        }

        assertNotEquals(englishDeck, otherEnglishDeck);
    }
}
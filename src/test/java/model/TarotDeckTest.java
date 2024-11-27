package model;

import model.decks.TarotDeck;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarotDeckTest {

    @Test
    public void test01TarotDeckShouldNotThrowAnyException() {
        // Arrange
        TarotDeck tarotDeck = new TarotDeck();
        int expectedAmountOfTarots = 15;
        // Act
        int obtainedAmountOfTarots = tarotDeck.fillDeck();
        // Assert
        assertEquals(expectedAmountOfTarots, obtainedAmountOfTarots);
    }
}

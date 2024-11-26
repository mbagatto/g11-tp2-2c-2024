package model;

import model.decks.JokerDeck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JokerDeckTest {

    @Test
    public void test01JokerDeckShouldBeFilledCorrectly() {
        // Arrange
        JokerDeck jokerDeck = new JokerDeck();
        int expectedAmountOfJokers = 33;
        // Act
        int obtainedAmountOfJokers = jokerDeck.fillDeck();
        // Assert
        assertEquals(expectedAmountOfJokers, obtainedAmountOfJokers);
    }
}

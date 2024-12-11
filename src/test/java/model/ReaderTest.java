package model;

import model.reader.DataReader;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReaderTest {
    @Test
    public void test01ShouldLoadEnglishCardsFromJsonFileCorrectly() {
        // Arrange
        DataReader reader = new DataReader();
        int expectedAmountOfCards = 52;
        // Act
        int obtainedAmountOfCards = reader.cardsRead().size();
        // Assert
        assertEquals(expectedAmountOfCards, obtainedAmountOfCards);
    }

    @Test
    public void test02RoundsMustBeCreatedCorrectlyFromJSON() {
        // Arrange
        DataReader reader = new DataReader();
        int expectedAmountOfRounds = 8;
        // Act
        int obtainedAmountOfRounds = reader.roundsRead().size();
        // Assert
        assertEquals(expectedAmountOfRounds, obtainedAmountOfRounds);
    }
}

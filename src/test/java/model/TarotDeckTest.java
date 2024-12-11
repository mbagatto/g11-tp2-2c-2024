package model;

import model.reader.DataReader;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarotDeckTest {

    @Test
    public void test01TarotDeckShouldNotThrowAnyException() {
        // Arrange
        DataReader reader = new DataReader();
        int expectedAmountOfTarots = 15;
        // Act
        int obtainedAmountOfTarots = reader.tarotsRead().size();
        // Assert
        assertEquals(expectedAmountOfTarots, obtainedAmountOfTarots);
    }
}

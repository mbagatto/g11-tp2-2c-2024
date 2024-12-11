package model;

import model.reader.DataReader;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JokerDeckTest {
    @Test
    public void test01JokerDeckShouldBeFilledCorrectly() {
        // Arrange
        DataReader reader = new DataReader();
        int expectedAmountOfJokers = 33;
        // Act
        int obtainedAmountOfJokers = reader.jokersRead().size();
        // Assert
        assertEquals(expectedAmountOfJokers, obtainedAmountOfJokers);
    }
}

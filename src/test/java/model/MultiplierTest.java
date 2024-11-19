package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplierTest {
    @Test
    public void test01AMultiplierShouldAddAMultiplierToAnother() {
        // Arrange
        Multiplier toChange = new Multiplier(10);
        Multiplier toAdd = new Multiplier(5);
        Multiplier expectedMultiplier = new Multiplier(15);
        // Act
        toChange.add(toAdd);
        // Assert
        assertEquals(toChange, expectedMultiplier);
    }
}

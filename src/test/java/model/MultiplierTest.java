package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplierTest {
    @Test
    public void shouldAddAMultiplierToAnother() {
        Multiplier toChange = new Multiplier(10);
        Multiplier toAdd = new Multiplier(5);
        Multiplier expectedMultiplier = new Multiplier(15);
        toChange.add(toAdd);
        assertEquals(toChange, expectedMultiplier);
    }
}

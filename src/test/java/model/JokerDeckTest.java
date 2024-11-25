package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class JokerDeckTest {

    @Test
    public void test01JokerDeckShouldBuildSuccesfully() {
        JokerDeck deck = new JokerDeck();
        assertDoesNotThrow(deck::fillDeck);
    }
}

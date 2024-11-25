package model;

import model.reader.JokerReader;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JokerDeckTest {

    @Test
    public void test01JokerDeckShouldBuildSuccesfully() {
//        JokerDeck deck = new JokerDeck();
//        assertDoesNotThrow(deck::fillDeck);
        JokerReader reader = new JokerReader();
        reader.read();
    }
}

package model;

import model.SpecialCards.JokerDeck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JokerDeckTest {
    @Test
    public void JokerDeckMustThrowExceptionWhenIsEmpty() {
        JokerDeck jokerDeck = new JokerDeck();
        assertThrows(EmptyDeckException.class, jokerDeck::deal);
    }
    @Test
    public void testJokerDeck() {
        JokerDeck jokerDeck = new JokerDeck();
        jokerDeck.fillDeck();
        assertNotNull(jokerDeck.deal());
    }
}

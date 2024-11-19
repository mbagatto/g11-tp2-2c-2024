package model;

import model.specialCards.JokerDeck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class JokerDeckTest {
    @Test
    public void test01JokerDeckMustThrowExceptionWhenIsEmpty() {
        JokerDeck jokerDeck = new JokerDeck();
        assertThrows(EmptyDeckException.class, jokerDeck::deal);
    }
    @Test
    public void test02JokerDeck() {
        JokerDeck jokerDeck = new JokerDeck();
        jokerDeck.fillDeck();
        assertNotNull(jokerDeck.deal());
    }
}

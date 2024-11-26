package model;

import model.decks.TarotDeck;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarotDeckTest {

    @Test
    public void test01TarotDeckShouldNotThrowAnyException() {
        TarotDeck tarotDeck = new TarotDeck();
        int obtained = tarotDeck.fillDeck();
        int expected = 15;
        assertEquals(obtained, expected);
    }
}

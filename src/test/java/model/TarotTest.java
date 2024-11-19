package model;

import model.cards.Card;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TarotTest {

    @Test
    public void testChangeCardMultiplierToSix() {
        Tarot tarot = new Tarot();
        tarot.setBehaviour(new ForMultiplier());
        int expectedScore = 30;
        Card card = new Card(5, "heart");
        card.applyTarot(tarot);
        assertEquals(expectedScore, card.calculateScore());
    }

    @Test
    public void testChangeHandPointsToTen() {
        Tarot tarot = new Tarot();
        tarot.setBehaviour(new ForValue());
        int expectedScore = 10;
        Card card = new Card(7, "spade");
        card.applyTarot(tarot);
        assertEquals(expectedScore, card.calculateScore());
    }
}

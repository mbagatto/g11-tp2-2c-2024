package model;

import model.Cards.Card;
import model.SpecialCards.ForMultiplier;
import model.SpecialCards.ForValue;
import model.SpecialCards.Tarot;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TarotTest {

    @Test
    public void testChangeCardMultiplierToSix() {
        Tarot tarot = new Tarot();
        tarot.setBehaviour(new ForMultiplier(6));
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

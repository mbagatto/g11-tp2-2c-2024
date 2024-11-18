package model;

import model.Cards.Card;
import model.SpecialCards.ForMultiplier;
import model.SpecialCards.Joker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JokerTest {
    @Test
    public void JokerShouldModifyMultiplierOfACardCorrectly() {
        Joker joker = new Joker();
        joker.setBehaviour(new ForMultiplier(8));
        String heartSuit = "heart";
        int heartValue = 4;
        Card card = new Card(heartValue, heartSuit);
        card.applyJoker(joker);
        int expectedScore = 32;
        assertEquals(card.calculateScore(), expectedScore);
    }
}

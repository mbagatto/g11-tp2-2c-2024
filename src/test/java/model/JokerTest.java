package model;

import model.cards.Spade;
import model.specialCards.Joker;
import model.cards.Card;
import model.score.Score;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JokerTest {
    @Test
    public void test01JokerShouldModifyMultiplierOfACardCorrectly() {
        // Arrange
        Score jokerScore = new Score(0, 8);
        ArrayList<Joker> jokers = new ArrayList<>();
        jokers.add(new Joker(jokerScore));
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Spade("10 de Picas", "10", 10, 1));
        playerDeck.selectCard(0);
        Score expectedScore = new Score(15, 9);
        // Act
        Score obtainedScore = playerDeck.playSelectedCards(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }
}

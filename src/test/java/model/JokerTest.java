package model;

import model.cards.Card;
import model.cards.Diamond;
import model.cards.Heart;
import model.cards.Spade;
import model.hands.Straight;
import model.jokers.ForTheScore;
import model.jokers.Joker;
import model.jokers.PlayedHandBonus;
import model.score.Score;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JokerTest {
    @Test
    public void test01JokerShouldModifyMultiplierOfACardCorrectly() {
        // Arrange
        ArrayList<Joker> jokers = new ArrayList<>();
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Spade(4));
        playerDeck.selectCard(0);
        Joker joker = new Joker("First Joker", new ForTheScore(new Score(0, 8)));
        jokers.add(joker);
        Score expectedScore = new Score(9, 9);
        // Act
        Score obtainedScore = playerDeck.playSelectedCards(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test02JokerShouldMultiplyBy3TheMultiplierOfAStraight() {
        // Arrange
        ArrayList<Joker> jokers = new ArrayList<>();
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Spade(4));
        playerDeck.addCard(new Diamond(6));
        playerDeck.addCard(new Heart(5));
        playerDeck.addCard(new Spade(3));
        playerDeck.addCard(new Spade(7));
        playerDeck.selectCard(0);
        playerDeck.selectCard(1);
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(4);
        ArrayList<Card> cards = new ArrayList<>();
        Joker joker = new Joker("Second Joker", new PlayedHandBonus(new Score(1, 3), new Straight(cards)));
        jokers.add(joker);
        Score expectedScore = new Score(55, 12);
        // Act
        Score obtainedScore = playerDeck.playSelectedCards(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }
}

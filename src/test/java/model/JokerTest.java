package model;

import model.cards.Card;
import model.cards.Diamond;
import model.cards.Heart;
import model.cards.Spade;
import model.hands.Straight;
import model.jokers.*;
import model.score.Score;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class JokerTest {
    @Test
    public void test01JokerShouldModifyMultiplierOfACardCorrectly() {
        // Arrange
        ArrayList<Joker> jokers = new ArrayList<>();
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Spade("4 de Picas", "4", 4, 1));
        playerDeck.selectCard(0);
        Joker joker = new ForTheScore("Octopus Joker", new Score(1, 8));
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
        playerDeck.addCard(new Spade("4 de Picas", "4", 4, 1));
        playerDeck.addCard(new Diamond("6 de Diamantes", "6", 6, 1));
        playerDeck.addCard(new Spade("5 de Corazones", "5", 5, 1));
        playerDeck.addCard(new Spade("3 de Picas", "3", 3, 1));
        playerDeck.addCard(new Spade("7 de Picas", "7", 7, 1));
        playerDeck.selectCard(0);
        playerDeck.selectCard(1);
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(4);
        ArrayList<Card> cards = new ArrayList<>();
        Joker joker = new PlayedHandBonus("Straight Joker", new Score(1, 3), new Straight(cards));
        jokers.add(joker);
        Score expectedScore = new Score(55, 7);
        // Act
        Score obtainedScore = playerDeck.playSelectedCards(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test03RandomJokerShouldBeActivated() {
        // Arrange
        Probability mockProbability = Mockito.mock(Probability.class);
        Mockito.when(mockProbability.calculate()).thenReturn(true);
        ArrayList<Joker> jokers = new ArrayList<>();
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Spade("10 de Picas", "10", 10, 1));
        playerDeck.selectCard(0);
        Joker joker = new ForMultiplierRA("Gros Michel", new Score(1, 15), mockProbability);
        jokers.add(joker);
        Score expectedScore = new Score(15, 16);
        // Act
        Score obtainedScore = playerDeck.playSelectedCards(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test04RandomJokerShouldNotBeActivated() {
        // Arrange
        Probability mockProbability = Mockito.mock(Probability.class);
        Mockito.when(mockProbability.calculate()).thenReturn(false);
        ArrayList<Joker> jokers = new ArrayList<>();
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Spade("10 de Picas", "10", 10, 1));
        playerDeck.selectCard(0);
        Joker joker = new ForMultiplierRA("Gros Michel", new Score(1, 15), mockProbability);
        jokers.add(joker);
        Score expectedScore = new Score(15, 1);
        // Act
        Score obtainedScore = playerDeck.playSelectedCards(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test07RandomJokerOfACombinatedJokerShouldBeActivated() {
        // Arrange
        Probability mockProbability = Mockito.mock(Probability.class);
        Mockito.when(mockProbability.calculate()).thenReturn(true);
        ArrayList<Joker> jokersForCombinated = new ArrayList<>();
        ArrayList<Joker> jokersForPlayerDeck = new ArrayList<>();
        ArrayList<Card> cards = new ArrayList<>();
        jokersForCombinated.add(new PlayedHandBonus("Straight Joker", new Score(1, 3), new Straight(cards)));
        jokersForCombinated.add(new ForTheScore("Octopus Joker", new Score(1, 8)));
        jokersForCombinated.add(new ForMultiplierRA("Gros Michel", new Score(1, 15), mockProbability));
        Joker joker = new Combinated("Combinated Supremacy", jokersForCombinated);
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Spade("4 de Picas", "4", 4, 1));
        playerDeck.addCard(new Diamond("6 de Diamantes", "6", 6, 1));
        playerDeck.addCard(new Heart("5 de Corazones", "5", 5, 1));
        playerDeck.addCard(new Spade("3 de Picas", "3", 3, 1));
        playerDeck.addCard(new Spade("7 de Picas", "7", 7, 1));
        playerDeck.selectCard(0);
        playerDeck.selectCard(1);
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(4);
        jokersForPlayerDeck.add(joker);
        Score expectedScore = new Score(55, 30);
        // Act
        Score obtainedScore = playerDeck.playSelectedCards(jokersForPlayerDeck);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test08RandomJokerOfACombinatedJokerShouldNotBeActivated() {
        // Arrange
        Probability mockProbability = Mockito.mock(Probability.class);
        Mockito.when(mockProbability.calculate()).thenReturn(false);
        ArrayList<Joker> jokersForCombinated = new ArrayList<>();
        ArrayList<Joker> jokersForPlayerDeck = new ArrayList<>();
        ArrayList<Card> cards = new ArrayList<>();
        jokersForCombinated.add(new PlayedHandBonus("Straight Joker", new Score(1, 3), new Straight(cards)));
        jokersForCombinated.add(new ForTheScore("Octopus Joker", new Score(1, 8)));
        jokersForCombinated.add(new ForMultiplierRA("Gros Michel", new Score(1, 15), mockProbability));
        Joker joker = new Combinated("Combinated Supremacy", jokersForCombinated);
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Spade("4 de Picas", "4", 4, 1));
        playerDeck.addCard(new Diamond("6 de Diamantes", "6", 6, 1));
        playerDeck.addCard(new Heart("5 de Corazones", "5", 5, 1));
        playerDeck.addCard(new Spade("3 de Picas", "3", 3, 1));
        playerDeck.addCard(new Spade("7 de Picas", "7", 7, 1));
        playerDeck.selectCard(0);
        playerDeck.selectCard(1);
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(4);
        jokersForPlayerDeck.add(joker);
        Score expectedScore = new Score(55, 15);
        // Act
        Score obtainedScore = playerDeck.playSelectedCards(jokersForPlayerDeck);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }
}

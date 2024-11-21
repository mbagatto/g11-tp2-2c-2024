package model;

import model.cards.Card;
import model.cards.Diamond;
import model.cards.Heart;
import model.cards.Spade;
import model.hands.Straight;
import model.jokers.*;
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
        playerDeck.addCard(new Spade("4 de Picas", "4", 4, 1));
        playerDeck.selectCard(0);
        Joker joker = new ForTheScore("First Joker", new Score(1, 8));
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
        Joker joker = new PlayedHandBonus("Second Joker", new Score(1, 3), new Straight(cards));
        jokers.add(joker);
        Score expectedScore = new Score(55, 7);
        // Act
        Score obtainedScore = playerDeck.playSelectedCards(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test03RandomJokerShouldBeActivatedWithAProbabilityOf6Correctly() {
        // Arrange
        ArrayList<Joker> jokers = new ArrayList<>();
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Spade("10 de Picas", "10", 10, 1));
        playerDeck.selectCard(0);
        Joker joker = new ForMultiplierRA("Gros Michel", new Score(1, 15), new Probability(6));
        jokers.add(joker);
        Score expectedScore = new Score(12, 16);
        // Act
        Score obtainedScore = playerDeck.playSelectedCards(jokers);

        while (!expectedScore.equals(obtainedScore)) {
            playerDeck.addCard(new Spade("7 de Picas", "7", 7, 1));
            playerDeck.selectCard(0);
            obtainedScore = playerDeck.playSelectedCards(jokers);
        }
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test04RandomJokerShouldBeActivatedWithAProbabilityOf20Correctly() {
        // Arrange
        ArrayList<Joker> jokers = new ArrayList<>();
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Spade("7 de Picas", "7", 7, 1));
        playerDeck.selectCard(0);
        Joker joker = new ForPointsRA("Golden Apple", new Score(500, 1), new Probability(20));
        jokers.add(joker);
        Score expectedScore = new Score(512, 1);
        // Act
        Score obtainedScore = playerDeck.playSelectedCards(jokers);
        while (!expectedScore.equals(obtainedScore)) {
            playerDeck.addCard(new Spade("7 de Picas", "7", 7, 1));
            playerDeck.selectCard(0);
            obtainedScore = playerDeck.playSelectedCards(jokers);
        }
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test05CombinatedJokerShouldCalculateCorrectlyAHandScore() {
        // Arrange
        ArrayList<Joker> jokersForCombinated = new ArrayList<>();
        ArrayList<Joker> jokersForPlayerDeck = new ArrayList<>();
        ArrayList<Card> cards = new ArrayList<>();
        jokersForCombinated.add(new PlayedHandBonus("Second Joker", new Score(1, 3), new Straight(cards)));
        jokersForCombinated.add(new ForTheScore("First Joker", new Score(1, 8)));
        jokersForCombinated.add(new ForMultiplierRA("Gros Michel", new Score(1, 15), new Probability(6)));
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

        while (!expectedScore.equals(obtainedScore)) {
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
            obtainedScore = playerDeck.playSelectedCards(jokersForPlayerDeck);
        }
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

}

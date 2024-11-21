package model;

import model.cards.*;
import model.jokers.Joker;
import model.score.Score;
import model.specialCards.ForMultiplier;
import model.specialCards.ForValue;
import model.specialCards.Tarot;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerDeckTest {

    @Test
    public void test01PlayerDeckIsEmptyWhenInitializated() {
        PlayerDeck deck = new PlayerDeck();
        assertFalse(deck.isComplete());
    }

    @Test
    public void test02WhenPlayingAPairItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Heart("2 de Corazones", "2", 2, 1));
        playerDeck.addCard(new Spade("8 de Picas", "8", 8, 1));
        playerDeck.addCard(new Heart("3 de Corazones", "3", 3, 1));
        playerDeck.addCard(new Spade("4 de Picas", "4", 4, 1));
        playerDeck.addCard(new Heart("8 de Corazones", "8", 8, 1));
        playerDeck.addCard(new Spade("Jota de Picas", "Jota", 10, 1));
        playerDeck.addCard(new Spade("5 de Picas", "5", 5, 1));
        playerDeck.addCard(new Heart("7 de Corazones", "7", 7, 1));

        playerDeck.selectCard(1);
        playerDeck.selectCard(4);
        playerDeck.selectCard(3);
        playerDeck.selectCard(2);
        playerDeck.selectCard(7);
        Score expectedScore = new Score(52, 1);
        ArrayList<Joker> jokers = new ArrayList<>();
        // Act
        Score obtainedScore = playerDeck.playSelectedCards(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test03WhenPlayingADoublePairItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Heart("2 de Corazones", "2", 2, 1));
        playerDeck.addCard(new Spade("8 de Picas", "8", 8, 1));
        playerDeck.addCard(new Heart("3 de Corazones", "3", 3, 1));
        playerDeck.addCard(new Spade("2 de Picas", "2", 2, 1));
        playerDeck.addCard(new Heart("8 de Corazones", "8", 8, 1));
        playerDeck.addCard(new Spade("Jota de Picas", "Jota", 10, 1));
        playerDeck.addCard(new Spade("5 de Picas", "5", 5, 1));
        playerDeck.addCard(new Heart("7 de Corazones", "7", 7, 1));
        playerDeck.selectCard(0);
        playerDeck.selectCard(4);
        playerDeck.selectCard(3);
        playerDeck.selectCard(1);
        playerDeck.selectCard(7);
        Score expectedScore = new Score(80, 1);
        ArrayList<Joker> jokers = new ArrayList<>();
        // Act
        Score obtainedScore = playerDeck.playSelectedCards(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }
    @Test
    public void test04WhenPlayingAThreeOfAKindItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Heart("2 de Corazones", "2", 2, 1));
        playerDeck.addCard(new Spade("8 de Picas", "8", 8, 1));
        playerDeck.addCard(new Diamond("8 de Diamantes", "8", 8, 1));
        playerDeck.addCard(new Spade("4 de Picas", "4", 4, 1));
        playerDeck.addCard(new Heart("8 de Corazones", "8", 8, 1));
        playerDeck.addCard(new Spade("Jota de Picas", "Jota", 10, 1));
        playerDeck.addCard(new Spade("5 de Picas", "5", 5, 1));
        playerDeck.addCard(new Heart("7 de Corazones", "7", 7, 1));
        playerDeck.selectCard(1);
        playerDeck.selectCard(4);
        playerDeck.selectCard(3);
        playerDeck.selectCard(2);
        playerDeck.selectCard(7);
        Score expectedScore = new Score(162, 1);
        ArrayList<Joker> jokers = new ArrayList<>();
        // Act
        Score obtainedScore = playerDeck.playSelectedCards(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test05WhenPlayingAStraightItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Heart("2 de Corazones", "2", 2, 1));
        playerDeck.addCard(new Spade("7 de Picas", "7", 7, 1));
        playerDeck.addCard(new Diamond("3 de Diamantes", "3", 3, 1));
        playerDeck.addCard(new Spade("4 de Picas", "4", 4, 1));
        playerDeck.addCard(new Heart("5 de Corazones", "5", 5, 1));
        playerDeck.addCard(new Spade("6 de Picas", "6", 6, 1));
        playerDeck.addCard(new Spade("5 de Picas", "5", 5, 1));
        playerDeck.addCard(new Heart("7 de Corazones", "7", 7, 1));

        playerDeck.selectCard(5);
        playerDeck.selectCard(1);
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(4);
        Score expectedScore = new Score(220, 1);
        ArrayList<Joker> jokers = new ArrayList<>();
        // Act
        Score obtainedScore = playerDeck.playSelectedCards(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test06WhenPlayingAFlushItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Heart("2 de Corazones", "2", 2, 1));
        playerDeck.addCard(new Spade("7 de Picas", "7", 7, 1));
        playerDeck.addCard(new Spade("3 de Picas", "3", 3, 1));
        playerDeck.addCard(new Spade("4 de Picas", "4", 4, 1));
        playerDeck.addCard(new Spade("5 de Picas", "5", 5, 1));
        playerDeck.addCard(new Spade("8 de Picas", "8", 8, 1));
        playerDeck.addCard(new Spade("5 de Picas", "5", 5, 1));
        playerDeck.addCard(new Heart("7 de Corazones", "7", 7, 1));
        playerDeck.selectCard(5);
        playerDeck.selectCard(1);
        playerDeck.selectCard(4);
        playerDeck.selectCard(3);
        playerDeck.selectCard(2);
        Score expectedScore = new Score(248, 1);
        ArrayList<Joker> jokers = new ArrayList<>();
        // Act
        Score obtainedScore = playerDeck.playSelectedCards(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test07WhenPlayingAFullHouseItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Heart("2 de Corazones", "2", 2, 1));
        playerDeck.addCard(new Diamond("5 de Diamantes", "5", 5, 1));
        playerDeck.addCard(new Heart("3 de Corazones", "3", 3, 1));
        playerDeck.addCard(new Spade("3 de Picas", "3", 3, 1));
        playerDeck.addCard(new Spade("5 de Picas", "5", 5, 1));
        playerDeck.addCard(new Spade("8 de Picas", "8", 8, 1));
        playerDeck.addCard(new Club("5 de Tréboles", "5", 5, 1));
        playerDeck.addCard(new Heart("7 de Corazones", "7", 7, 1));

        playerDeck.selectCard(6);
        playerDeck.selectCard(1);
        playerDeck.selectCard(4);
        playerDeck.selectCard(3);
        playerDeck.selectCard(2);
        Score expectedScore = new Score(244, 1);
        ArrayList<Joker> jokers = new ArrayList<>();
        // Act
        Score obtainedScore = playerDeck.playSelectedCards(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test08WhenPlayingAFourOfAKindItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Heart("2 de Corazones", "2", 2, 1));
        playerDeck.addCard(new Diamond("5 de Diamantes", "5", 5, 1));
        playerDeck.addCard(new Heart("5 de Corazones", "5", 5, 1));
        playerDeck.addCard(new Spade("3 de Picas", "3", 3, 1));
        playerDeck.addCard(new Spade("5 de Picas", "5", 5, 1));
        playerDeck.addCard(new Spade("8 de Picas", "8", 8, 1));
        playerDeck.addCard(new Club("5 de Tréboles", "5", 5, 1));
        playerDeck.addCard(new Heart("7 de Corazones", "7", 7, 1));

        playerDeck.selectCard(6);
        playerDeck.selectCard(1);
        playerDeck.selectCard(4);
        playerDeck.selectCard(3);
        playerDeck.selectCard(2);
        Score expectedScore = new Score(560, 1);
        ArrayList<Joker> jokers = new ArrayList<>();
        // Act
        Score obtainedScore = playerDeck.playSelectedCards(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test09WhenPlayingAStraightFlushItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Heart("6 de Corazones", "6", 6, 1));
        playerDeck.addCard(new Diamond("5 de Diamantes", "5", 5, 1));
        playerDeck.addCard(new Heart("5 de Corazones", "5", 5, 1));
        playerDeck.addCard(new Heart("7 de Corazones", "7", 7, 1));
        playerDeck.addCard(new Spade("5 de Picas", "5", 5, 1));
        playerDeck.addCard(new Heart("8 de Corazones", "8", 8, 1));
        playerDeck.addCard(new Heart("9 de Corazones", "9", 9, 1));
        playerDeck.addCard(new Heart("2 de Corazones", "2", 2, 1));

        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(5);
        playerDeck.selectCard(6);
        playerDeck.selectCard(0);
        Score expectedScore = new Score(1080, 1);
        ArrayList<Joker> jokers = new ArrayList<>();
        // Act
        Score obtainedScore = playerDeck.playSelectedCards(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test10WhenPlayingARoyalFlushItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Heart("10 de Corazones", "10", 10, 1));
        playerDeck.addCard(new Diamond("5 de Diamantes", "5", 5, 1));
        playerDeck.addCard(new Heart("As de Corazones", "As", 10, 1));
        playerDeck.addCard(new Heart("Rey de Corazones", "Rey", 10, 1));
        playerDeck.addCard(new Spade("5 de Picas", "5", 5, 1));
        playerDeck.addCard(new Heart("Reina de Corazones", "Reina", 10, 1));
        playerDeck.addCard(new Heart("Jota de Corazones", "Jota", 10, 1));
        playerDeck.addCard(new Heart("2 de Corazones", "2", 2, 1));

        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(5);
        playerDeck.selectCard(6);
        playerDeck.selectCard(0);
        Score expectedScore = new Score(150, 8);
        ArrayList<Joker> jokers = new ArrayList<>();
        // Act
        Score obtainedScore = playerDeck.playSelectedCards(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test11WhenPlayingAHighCardItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Heart("10 de Corazones", "10", 10, 1));
        playerDeck.addCard(new Diamond("5 de Diamantes", "5", 5, 1));
        playerDeck.addCard(new Club("As de Trebol", "As", 10, 1));
        playerDeck.addCard(new Heart("3 de Corazones", "3", 3, 1));
        playerDeck.addCard(new Spade("5 de Picas", "5", 5, 1));
        playerDeck.addCard(new Diamond("Reina de Diamantes", "12", 10, 1));
        playerDeck.addCard(new Spade("Jota de Picas", "11", 10, 1));
        playerDeck.addCard(new Heart("2 de Corazones", "2", 2, 1));

        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(5);
        playerDeck.selectCard(6);
        playerDeck.selectCard(0);
        Score expectedScore = new Score(15, 1);
        ArrayList<Joker> jokers = new ArrayList<>();
        // Act
        Score obtainedScore = playerDeck.playSelectedCards(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test12WhenPlayingATarotShouldModifyFinalScoreOfAHighCard() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Heart("10 de Corazones", "10", 10, 1));
        playerDeck.addCard(new Diamond("5 de Diamantes", "5", 5, 1));
        playerDeck.addCard(new Club("As de Trebol", "As", 10, 1));
        playerDeck.addCard(new Heart("3 de Corazones", "3", 3, 1));
        playerDeck.addCard(new Spade("5 de Picas", "5", 5, 1));
        playerDeck.addCard(new Diamond("Reina de Diamantes", "12", 10, 1));
        playerDeck.addCard(new Spade("Jota de Picas", "11", 10, 1));
        playerDeck.addCard(new Heart("2 de Corazones", "2", 2, 1));

        Score expectedScore = new Score(15, 7);
        ArrayList<Joker> jokers = new ArrayList<>();
        // Act
        Tarot tarot = new Tarot();
        tarot.setBehaviour(new ForValue());
        playerDeck.playTarot(2,tarot);

        tarot.setBehaviour(new ForMultiplier(6));
        playerDeck.playTarot(2,tarot);
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(5);
        playerDeck.selectCard(6);
        playerDeck.selectCard(0);
        Score obtainedScore = playerDeck.playSelectedCards(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test13VerifyThatTheOrderDoesNotChangeTheScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Heart("5 de Corazones", "5", 5, 1));
        playerDeck.addCard(new Heart("6 de Corazones", "6", 6, 1));
        playerDeck.addCard(new Heart("7 de Corazones", "7", 7, 1));
        playerDeck.addCard(new Heart("8 de Corazones", "8", 8, 1));
        playerDeck.addCard(new Heart("9 de Corazones", "9", 9, 1));
        playerDeck.addCard(new Diamond("2 de Diamantes", "2", 2, 1));
        playerDeck.addCard(new Spade("6 de Picas", "6", 6, 1));
        playerDeck.addCard(new Spade("8 de Picas", "8", 8, 1));
        ArrayList<Joker> jokers = new ArrayList<>();
        // Act
        playerDeck.selectCard(0);
        playerDeck.selectCard(1);
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(4);
        Score score1 = playerDeck.playSelectedCards(jokers);
        playerDeck.clear();
        playerDeck.addCard(new Heart("5 de Corazones", "5", 5, 1));
        playerDeck.addCard(new Heart("6 de Corazones", "6", 6, 1));
        playerDeck.addCard(new Heart("7 de Corazones", "7", 7, 1));
        playerDeck.addCard(new Heart("8 de Corazones", "8", 8, 1));
        playerDeck.addCard(new Heart("9 de Corazones", "9", 9, 1));
        playerDeck.addCard(new Diamond("2 de Diamantes", "2", 2, 1));
        playerDeck.addCard(new Spade("6 de Picas", "6", 6, 1));
        playerDeck.addCard(new Spade("8 de Picas", "8", 8, 1));
        playerDeck.selectCard(2);
        playerDeck.selectCard(4);
        playerDeck.selectCard(1);
        playerDeck.selectCard(3);
        playerDeck.selectCard(0);
        Score score2 = playerDeck.playSelectedCards(jokers);
        // Assert
        assertEquals(score1, score2);
    }
}

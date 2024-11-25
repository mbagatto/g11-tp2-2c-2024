package model;

import model.cards.*;
import model.score.Score;
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
        playerDeck.addCard(new Heart("2", new Score(2), new Score(1)));
        playerDeck.addCard(new Spade("8", new Score(8), new Score(1)));
        playerDeck.addCard(new Heart("3", new Score(3), new Score(1)));
        playerDeck.addCard(new Spade("4", new Score(4), new Score(1)));
        playerDeck.addCard(new Heart("8", new Score(8), new Score(1)));
        playerDeck.addCard(new Spade("Jota", new Score(10), new Score(1)));
        playerDeck.addCard(new Spade("5", new Score(5), new Score(1)));
        playerDeck.addCard(new Heart("7", new Score(7), new Score(1)));
        playerDeck.selectCard(1);
        playerDeck.selectCard(4);
        playerDeck.selectCard(3);
        playerDeck.selectCard(2);
        playerDeck.selectCard(7);
        Score expectedScore = new Score(52);
        // Act
        Score obtainedScore = playerDeck.play(new ArrayList<>());
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test03WhenPlayingADoublePairItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Heart("2", new Score(2), new Score(1)));
        playerDeck.addCard(new Spade("2", new Score(2), new Score(1)));
        playerDeck.addCard(new Heart("8", new Score(8), new Score(1)));
        playerDeck.addCard(new Spade("8", new Score(8), new Score(1)));
        playerDeck.addCard(new Heart("5", new Score(5), new Score(1)));
        playerDeck.addCard(new Spade("Jota", new Score(10), new Score(1)));
        playerDeck.addCard(new Spade("5", new Score(5), new Score(1)));
        playerDeck.addCard(new Heart("7", new Score(7), new Score(1)));
        playerDeck.selectCard(0);
        playerDeck.selectCard(1);
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(4);
        Score expectedScore = new Score(80);
        // Act
        Score obtainedScore = playerDeck.play(new ArrayList<>());
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }
    @Test
    public void test04WhenPlayingAThreeOfAKindItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Heart("8", new Score(8), new Score(1)));
        playerDeck.addCard(new Spade("8", new Score(8), new Score(1)));
        playerDeck.addCard(new Diamond("8", new Score(8), new Score(1)));
        playerDeck.addCard(new Spade("4", new Score(4), new Score(1)));
        playerDeck.addCard(new Heart("5", new Score(5), new Score(1)));
        playerDeck.addCard(new Spade("Jota", new Score(10), new Score(1)));
        playerDeck.addCard(new Spade("5", new Score(5), new Score(1)));
        playerDeck.addCard(new Heart("7", new Score(7), new Score(1)));
        playerDeck.selectCard(0);
        playerDeck.selectCard(1);
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(4);
        Score expectedScore = new Score(162);
        // Act
        Score obtainedScore = playerDeck.play(new ArrayList<>());
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test05WhenPlayingAStraightItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Heart("2", new Score(2), new Score(1)));
        playerDeck.addCard(new Spade("3", new Score(3), new Score(1)));
        playerDeck.addCard(new Heart("4", new Score(4), new Score(1)));
        playerDeck.addCard(new Spade("5", new Score(5), new Score(1)));
        playerDeck.addCard(new Heart("6", new Score(6), new Score(1)));
        playerDeck.addCard(new Spade("Jota", new Score(10), new Score(1)));
        playerDeck.addCard(new Spade("5", new Score(5), new Score(1)));
        playerDeck.addCard(new Heart("7", new Score(7), new Score(1)));
        playerDeck.selectCard(0);
        playerDeck.selectCard(1);
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(4);
        Score expectedScore = new Score(200);
        // Act
        Score obtainedScore = playerDeck.play(new ArrayList<>());
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test06WhenPlayingAFlushItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Heart("2", new Score(2), new Score(1)));
        playerDeck.addCard(new Heart("10", new Score(10), new Score(1)));
        playerDeck.addCard(new Heart("4", new Score(4), new Score(1)));
        playerDeck.addCard(new Heart("7", new Score(7), new Score(1)));
        playerDeck.addCard(new Heart("6", new Score(6), new Score(1)));
        playerDeck.addCard(new Spade("Jota", new Score(10), new Score(1)));
        playerDeck.addCard(new Spade("5", new Score(5), new Score(1)));
        playerDeck.addCard(new Heart("Jota", new Score(10), new Score(1)));
        playerDeck.selectCard(0);
        playerDeck.selectCard(1);
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(4);
        Score expectedScore = new Score(256);
        // Act
        Score obtainedScore = playerDeck.play(new ArrayList<>());
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test07WhenPlayingAFullHouseItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Heart("2", new Score(2), new Score(1)));
        playerDeck.addCard(new Spade("2", new Score(2), new Score(1)));
        playerDeck.addCard(new Club("2", new Score(2), new Score(1)));
        playerDeck.addCard(new Heart("3", new Score(3), new Score(1)));
        playerDeck.addCard(new Spade("3", new Score(3), new Score(1)));
        playerDeck.addCard(new Spade("Jota", new Score(10), new Score(1)));
        playerDeck.addCard(new Spade("5", new Score(5), new Score(1)));
        playerDeck.addCard(new Heart("Jota", new Score(10), new Score(1)));
        playerDeck.selectCard(0);
        playerDeck.selectCard(1);
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(4);
        Score expectedScore = new Score(208);
        // Act
        Score obtainedScore = playerDeck.play(new ArrayList<>());
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test08WhenPlayingAFourOfAKindItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Heart("2", new Score(2), new Score(1)));
        playerDeck.addCard(new Diamond("2", new Score(2), new Score(1)));
        playerDeck.addCard(new Spade("2", new Score(2), new Score(1)));
        playerDeck.addCard(new Club("2", new Score(2), new Score(1)));
        playerDeck.addCard(new Heart("6", new Score(6), new Score(1)));
        playerDeck.addCard(new Spade("Jota", new Score(10), new Score(1)));
        playerDeck.addCard(new Spade("5", new Score(5), new Score(1)));
        playerDeck.addCard(new Heart("Jota", new Score(10), new Score(1)));
        playerDeck.selectCard(0);
        playerDeck.selectCard(1);
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(4);
        Score expectedScore = new Score(476);
        // Act
        Score obtainedScore = playerDeck.play(new ArrayList<>());
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test09WhenPlayingAStraightFlushItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Heart("2", new Score(2), new Score(1)));
        playerDeck.addCard(new Heart("3", new Score(3), new Score(1)));
        playerDeck.addCard(new Heart("4", new Score(4), new Score(1)));
        playerDeck.addCard(new Heart("5", new Score(5), new Score(1)));
        playerDeck.addCard(new Heart("6", new Score(6), new Score(1)));
        playerDeck.addCard(new Spade("Jota", new Score(10), new Score(1)));
        playerDeck.addCard(new Spade("5", new Score(5), new Score(1)));
        playerDeck.addCard(new Heart("Jota", new Score(10), new Score(1)));
        playerDeck.selectCard(0);
        playerDeck.selectCard(1);
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(4);
        Score expectedScore = new Score(960);
        // Act
        Score obtainedScore = playerDeck.play(new ArrayList<>());
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test10WhenPlayingARoyalFlushItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Heart("10", new Score(10), new Score(1)));
        playerDeck.addCard(new Heart("Jota", new Score(10), new Score(1)));
        playerDeck.addCard(new Heart("Reina", new Score(10), new Score(1)));
        playerDeck.addCard(new Heart("Rey", new Score(10), new Score(1)));
        playerDeck.addCard(new Heart("As", new Score(10), new Score(1)));
        playerDeck.addCard(new Spade("Jota", new Score(10), new Score(1)));
        playerDeck.addCard(new Spade("5", new Score(5), new Score(1)));
        playerDeck.addCard(new Heart("Jota", new Score(10), new Score(1)));
        playerDeck.selectCard(0);
        playerDeck.selectCard(1);
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(4);
        Score expectedScore = new Score(1200);
        // Act
        Score obtainedScore = playerDeck.play(new ArrayList<>());
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test11WhenPlayingAHighCardItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Heart("2", new Score(2), new Score(1)));
        playerDeck.addCard(new Heart("3", new Score(3), new Score(1)));
        playerDeck.addCard(new Spade("Rey", new Score(10), new Score(1)));
        playerDeck.addCard(new Heart("5", new Score(5), new Score(1)));
        playerDeck.addCard(new Heart("As", new Score(10), new Score(1)));
        playerDeck.addCard(new Spade("Jota", new Score(10), new Score(1)));
        playerDeck.addCard(new Spade("5", new Score(5), new Score(1)));
        playerDeck.addCard(new Heart("Jota", new Score(10), new Score(1)));
        playerDeck.selectCard(0);
        playerDeck.selectCard(1);
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(4);
        Score expectedScore = new Score(15);
        // Act
        Score obtainedScore = playerDeck.play(new ArrayList<>());
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test12VerifyThatTheOrderDoesNotChangeTheScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Heart("5", new Score(5), new Score(1)));
        playerDeck.addCard(new Heart("6", new Score(6), new Score(1)));
        playerDeck.addCard(new Heart("7", new Score(7), new Score(1)));
        playerDeck.addCard(new Heart("8", new Score(8), new Score(1)));
        playerDeck.addCard(new Heart("9", new Score(9), new Score(1)));
        playerDeck.addCard(new Diamond("2", new Score(2), new Score(1)));
        playerDeck.addCard(new Spade("6", new Score(6), new Score(1)));
        playerDeck.addCard(new Spade("8", new Score(8), new Score(1)));
        // Act
        playerDeck.selectCard(0);
        playerDeck.selectCard(1);
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(4);
        Score score1 = playerDeck.play(new ArrayList<>());
        playerDeck.reset();
        playerDeck.addCard(new Heart("5", new Score(5), new Score(1)));
        playerDeck.addCard(new Heart("6", new Score(6), new Score(1)));
        playerDeck.addCard(new Heart("7", new Score(7), new Score(1)));
        playerDeck.addCard(new Heart("8", new Score(8), new Score(1)));
        playerDeck.addCard(new Heart("9", new Score(9), new Score(1)));
        playerDeck.addCard(new Diamond("2", new Score(2), new Score(1)));
        playerDeck.addCard(new Spade("6", new Score(6), new Score(1)));
        playerDeck.addCard(new Spade("8", new Score(8), new Score(1)));
        playerDeck.selectCard(2);
        playerDeck.selectCard(4);
        playerDeck.selectCard(1);
        playerDeck.selectCard(3);
        playerDeck.selectCard(0);
        Score score2 = playerDeck.play(new ArrayList<>());
        // Assert
        assertEquals(score1, score2);
    }

//    @Test
//    public void test13WhenPlayingATarotShouldModifyFinalScoreOfAHighCard() {
//        // Arrange
//        PlayerDeck playerDeck = new PlayerDeck();
//        playerDeck.addCard(new Heart("10 de Corazones", "10", 10, 1));
//        playerDeck.addCard(new Diamond("5 de Diamantes", "5", 5, 1));
//        playerDeck.addCard(new Club("As de Trebol", "As", 10, 1));
//        playerDeck.addCard(new Heart("3 de Corazones", "3", 3, 1));
//        playerDeck.addCard(new Spade("5 de Picas", "5", 5, 1));
//        playerDeck.addCard(new Diamond("Reina de Diamantes", "12", 10, 1));
//        playerDeck.addCard(new Spade("Jota de Picas", "11", 10, 1));
//        playerDeck.addCard(new Heart("2 de Corazones", "2", 2, 1));
//
//        Score expectedScore = new Score(15, 7);
//        ArrayList<Joker> jokers = new ArrayList<>();
//        // Act
//        Tarot tarot = new Tarot();
//        tarot.setBehaviour(new ForValue());
//        playerDeck.playTarot(2,tarot);
//
//        tarot.setBehaviour(new ForMultiplier(6));
//        playerDeck.playTarot(2,tarot);
//        playerDeck.selectCard(2);
//        playerDeck.selectCard(3);
//        playerDeck.selectCard(5);
//        playerDeck.selectCard(6);
//        playerDeck.selectCard(0);
//        Score obtainedScore = playerDeck.playSelectedCards(jokers);
//        // Assert
//        assertEquals(expectedScore, obtainedScore);
//    }
}

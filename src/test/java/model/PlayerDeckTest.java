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
        playerDeck.addCard(new Heart(2));
        playerDeck.addCard(new Spade(8));
        playerDeck.addCard(new Heart(3));
        playerDeck.addCard(new Spade(4));
        playerDeck.addCard(new Heart(8));
        playerDeck.addCard(new Spade(11));
        playerDeck.addCard(new Spade(5));
        playerDeck.addCard(new Heart(7));

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
        playerDeck.addCard(new Heart(2));
        playerDeck.addCard(new Spade(8));
        playerDeck.addCard(new Heart(3));
        playerDeck.addCard(new Spade(2));
        playerDeck.addCard(new Heart(8));
        playerDeck.addCard(new Spade(11));
        playerDeck.addCard(new Spade(5));
        playerDeck.addCard(new Heart(7));
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
        playerDeck.addCard(new Heart(2));
        playerDeck.addCard(new Spade(8));
        playerDeck.addCard(new Diamond(8));
        playerDeck.addCard(new Spade(4));
        playerDeck.addCard(new Heart(8));
        playerDeck.addCard(new Spade(11));
        playerDeck.addCard(new Spade(5));
        playerDeck.addCard(new Heart(7));
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
        playerDeck.addCard(new Heart(2));
        playerDeck.addCard(new Spade(7));
        playerDeck.addCard(new Diamond(3));
        playerDeck.addCard(new Spade(4));
        playerDeck.addCard(new Heart(5));
        playerDeck.addCard(new Spade(6));
        playerDeck.addCard(new Spade(5));
        playerDeck.addCard(new Heart(7));

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
        playerDeck.addCard(new Heart(2));
        playerDeck.addCard(new Spade(7));
        playerDeck.addCard(new Spade(3));
        playerDeck.addCard(new Spade(4));
        playerDeck.addCard(new Spade(5));
        playerDeck.addCard(new Spade(8));
        playerDeck.addCard(new Spade(5));
        playerDeck.addCard(new Heart(7));
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
        playerDeck.addCard(new Heart(2));
        playerDeck.addCard(new Diamond(5));
        playerDeck.addCard(new Heart(3));
        playerDeck.addCard(new Spade(3));
        playerDeck.addCard(new Spade(5));
        playerDeck.addCard(new Spade(8));
        playerDeck.addCard(new Club(5));
        playerDeck.addCard(new Heart(7));

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
        playerDeck.addCard(new Heart(2));
        playerDeck.addCard(new Diamond(5));
        playerDeck.addCard(new Heart(5));
        playerDeck.addCard(new Spade(3));
        playerDeck.addCard(new Spade(5));
        playerDeck.addCard(new Spade(8));
        playerDeck.addCard(new Club(5));
        playerDeck.addCard(new Heart(7));

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
        playerDeck.addCard(new Heart(6));
        playerDeck.addCard(new Diamond(5));
        playerDeck.addCard(new Heart(5));
        playerDeck.addCard(new Heart(7));
        playerDeck.addCard(new Spade(5));
        playerDeck.addCard(new Heart(8));
        playerDeck.addCard(new Heart(9));
        playerDeck.addCard(new Heart(2));

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
        playerDeck.addCard(new Heart(10));
        playerDeck.addCard(new Diamond(5));
        playerDeck.addCard(new Heart(14));
        playerDeck.addCard(new Heart(13));
        playerDeck.addCard(new Spade(5));
        playerDeck.addCard(new Heart(12));
        playerDeck.addCard(new Heart(11));
        playerDeck.addCard(new Heart(2));

        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(5);
        playerDeck.selectCard(6);
        playerDeck.selectCard(0);
        Score expectedScore = new Score(1280, 1);
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
        playerDeck.addCard(new Heart(10));
        playerDeck.addCard(new Diamond(5));
        playerDeck.addCard(new Club(14));
        playerDeck.addCard(new Heart(3));
        playerDeck.addCard(new Spade(5));
        playerDeck.addCard(new Diamond(12));
        playerDeck.addCard(new Spade(11));
        playerDeck.addCard(new Heart(2));
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(5);
        playerDeck.selectCard(6);
        playerDeck.selectCard(0);
        Score expectedScore = new Score(19, 1);
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
        playerDeck.addCard(new Heart(10));
        playerDeck.addCard(new Diamond(5));
        playerDeck.addCard(new Club(14));
        playerDeck.addCard(new Heart(3));
        playerDeck.addCard(new Spade(5));
        playerDeck.addCard(new Diamond(12));
        playerDeck.addCard(new Spade(11));
        playerDeck.addCard(new Heart(2));

        Score expectedScore = new Score(21, 5);
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
        playerDeck.addCard(new Heart(5));
        playerDeck.addCard(new Heart(6));
        playerDeck.addCard(new Heart(7));
        playerDeck.addCard(new Heart(8));
        playerDeck.addCard(new Heart(9));
        playerDeck.addCard(new Diamond(2));
        playerDeck.addCard(new Spade(6));
        playerDeck.addCard(new Spade(8));
        ArrayList<Joker> jokers = new ArrayList<>();
        // Act
        playerDeck.selectCard(0);
        playerDeck.selectCard(1);
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(4);
        Score score1 = playerDeck.playSelectedCards(jokers);
        playerDeck.clear();
        playerDeck.addCard(new Heart(5));
        playerDeck.addCard(new Heart(6));
        playerDeck.addCard(new Heart(7));
        playerDeck.addCard(new Heart(8));
        playerDeck.addCard(new Heart(9));
        playerDeck.addCard(new Diamond(2));
        playerDeck.addCard(new Spade(6));
        playerDeck.addCard(new Spade(8));
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

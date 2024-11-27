package model;

import model.cards.*;
import model.decks.PlayerDeck;
import model.hands.*;
import model.score.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerDeckTest {
    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        Field instance = HighCard.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        instance = Pair.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        instance = TwoPair.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        instance = ThreeOfAKind.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        instance = Straight.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        instance = Flush.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        instance = FullHouse.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        instance = FourOfAKind.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        instance = StraightFlush.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        instance = RoyalFlush.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
    }

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
        PlayerDeck firstPlayerDeck = new PlayerDeck();
        firstPlayerDeck.addCard(new Heart("5", new Score(5), new Score(1)));
        firstPlayerDeck.addCard(new Heart("6", new Score(6), new Score(1)));
        firstPlayerDeck.addCard(new Heart("7", new Score(7), new Score(1)));
        firstPlayerDeck.addCard(new Heart("8", new Score(8), new Score(1)));
        firstPlayerDeck.addCard(new Heart("9", new Score(9), new Score(1)));
        firstPlayerDeck.addCard(new Diamond("2", new Score(2), new Score(1)));
        firstPlayerDeck.addCard(new Spade("6", new Score(6), new Score(1)));
        firstPlayerDeck.addCard(new Spade("8", new Score(8), new Score(1)));
        // Act
        firstPlayerDeck.selectCard(0);
        firstPlayerDeck.selectCard(1);
        firstPlayerDeck.selectCard(2);
        firstPlayerDeck.selectCard(3);
        firstPlayerDeck.selectCard(4);
        Score firstScore = firstPlayerDeck.play(new ArrayList<>());
        PlayerDeck secondPlayerDeck = new PlayerDeck();
        secondPlayerDeck.addCard(new Heart("5", new Score(5), new Score(1)));
        secondPlayerDeck.addCard(new Heart("6", new Score(6), new Score(1)));
        secondPlayerDeck.addCard(new Heart("7", new Score(7), new Score(1)));
        secondPlayerDeck.addCard(new Heart("8", new Score(8), new Score(1)));
        secondPlayerDeck.addCard(new Heart("9", new Score(9), new Score(1)));
        secondPlayerDeck.addCard(new Diamond("2", new Score(2), new Score(1)));
        secondPlayerDeck.addCard(new Spade("6", new Score(6), new Score(1)));
        secondPlayerDeck.addCard(new Spade("8", new Score(8), new Score(1)));
        secondPlayerDeck.selectCard(2);
        secondPlayerDeck.selectCard(4);
        secondPlayerDeck.selectCard(1);
        secondPlayerDeck.selectCard(3);
        secondPlayerDeck.selectCard(0);
        Score secondScore = secondPlayerDeck.play(new ArrayList<>());
        // Assert
        assertEquals(firstScore, secondScore);
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

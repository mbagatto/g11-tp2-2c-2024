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
        Card eightOfSpades = new Spade("8", new Score(8), new Score(1));
        Card eightOfHearts = new Heart("8", new Score(8), new Score(1));
        playerDeck.addCard(eightOfSpades);
        playerDeck.addCard(eightOfHearts);
        playerDeck.addCard(eightOfSpades);
        playerDeck.addCard(eightOfHearts);

        playerDeck.selectCard(eightOfSpades);
        playerDeck.selectCard(eightOfHearts);

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
        Card eightOfSpades = new Spade("8", new Score(8), new Score(1));
        Card eightOfHearts = new Heart("8", new Score(8), new Score(1));
        Card twoOfHearts = new Heart("2", new Score(2), new Score(1));
        Card twoOfSpades = new Spade("2", new Score(2), new Score(1));
        playerDeck.addCard(eightOfSpades);
        playerDeck.addCard(eightOfHearts);
        playerDeck.addCard(twoOfHearts);
        playerDeck.addCard(twoOfSpades);

        playerDeck.selectCard(eightOfSpades);
        playerDeck.selectCard(eightOfHearts);
        playerDeck.selectCard(twoOfHearts);
        playerDeck.selectCard(twoOfSpades);

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
        Card eightOfSpades = new Spade("8", new Score(8), new Score(1));
        Card eightOfHearts = new Heart("8", new Score(8), new Score(1));
        Card eightOfDiamonds = new Diamond("8", new Score(8), new Score(1));
        playerDeck.addCard(eightOfSpades);
        playerDeck.addCard(eightOfHearts);
        playerDeck.addCard(eightOfDiamonds);

        playerDeck.selectCard(eightOfSpades);
        playerDeck.selectCard(eightOfHearts);
        playerDeck.selectCard(eightOfDiamonds);

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
        Card twoOfHearts = new Heart("2", new Score(2), new Score(1));
        Card threeOfHearts = new Heart("3", new Score(3), new Score(1));
        Card fourOfHearts = new Heart("4", new Score(4), new Score(1));
        Card fiveOfHearts = new Heart("5", new Score(5), new Score(1));
        Card sixOfDiamonds = new Diamond("6", new Score(6), new Score(1));
        playerDeck.addCard(twoOfHearts);
        playerDeck.addCard(threeOfHearts);
        playerDeck.addCard(fourOfHearts);
        playerDeck.addCard(fiveOfHearts);
        playerDeck.addCard(sixOfDiamonds);

        playerDeck.selectCard(twoOfHearts);
        playerDeck.selectCard(threeOfHearts);
        playerDeck.selectCard(fourOfHearts);
        playerDeck.selectCard(fiveOfHearts);
        playerDeck.selectCard(sixOfDiamonds);

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
        Card twoOfHearts = new Heart("2", new Score(2), new Score(1));
        Card threeOfHearts = new Heart("3", new Score(3), new Score(1));
        Card sevenOfHearts = new Heart("7", new Score(7), new Score(1));
        Card fiveOfHearts = new Heart("5", new Score(5), new Score(1));
        Card tenOfHearts = new Heart("10", new Score(10), new Score(1));
        playerDeck.addCard(twoOfHearts);
        playerDeck.addCard(threeOfHearts);
        playerDeck.addCard(sevenOfHearts);
        playerDeck.addCard(fiveOfHearts);
        playerDeck.addCard(tenOfHearts);

        playerDeck.selectCard(twoOfHearts);
        playerDeck.selectCard(threeOfHearts);
        playerDeck.selectCard(sevenOfHearts);
        playerDeck.selectCard(fiveOfHearts);
        playerDeck.selectCard(tenOfHearts);

        Score expectedScore = new Score(248);
        // Act
        Score obtainedScore = playerDeck.play(new ArrayList<>());
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test07WhenPlayingAFullHouseItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        Card twoOfHearts = new Heart("2", new Score(2), new Score(1));
        Card twoOfSpades = new Spade("2", new Score(2), new Score(1));
        Card threeOfHearts = new Heart("3", new Score(3), new Score(1));
        Card threeOfSpades = new Spade("3", new Score(3), new Score(1));
        Card threeOfDiamonds = new Diamond("3", new Score(3), new Score(1));
        playerDeck.addCard(twoOfHearts);
        playerDeck.addCard(twoOfSpades);
        playerDeck.addCard(threeOfHearts);
        playerDeck.addCard(threeOfSpades);
        playerDeck.addCard(threeOfDiamonds);

        playerDeck.selectCard(twoOfHearts);
        playerDeck.selectCard(twoOfSpades);
        playerDeck.selectCard(threeOfHearts);
        playerDeck.selectCard(threeOfSpades);
        playerDeck.selectCard(threeOfDiamonds);

        Score expectedScore = new Score(212);
        // Act
        Score obtainedScore = playerDeck.play(new ArrayList<>());
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test08WhenPlayingAFourOfAKindItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        Card twoOfHearts = new Heart("2", new Score(2), new Score(1));
        Card twoOfSpades = new Spade("2", new Score(2), new Score(1));
        Card twoOfDiamonds = new Diamond("2", new Score(2), new Score(1));
        Card twoOfClubs = new Club("2", new Score(2), new Score(1));
        playerDeck.addCard(twoOfHearts);
        playerDeck.addCard(twoOfSpades);
        playerDeck.addCard(twoOfDiamonds);
        playerDeck.addCard(twoOfClubs);

        playerDeck.selectCard(twoOfHearts);
        playerDeck.selectCard(twoOfSpades);
        playerDeck.selectCard(twoOfDiamonds);
        playerDeck.selectCard(twoOfClubs);

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
        Card twoOfHearts = new Heart("2", new Score(2), new Score(1));
        Card threeOfHearts = new Heart("3", new Score(3), new Score(1));
        Card fourOfHearts = new Heart("4", new Score(4), new Score(1));
        Card fiveOfHearts = new Heart("5", new Score(5), new Score(1));
        Card sixOfHearts = new Heart("6", new Score(6), new Score(1));
        playerDeck.addCard(twoOfHearts);
        playerDeck.addCard(threeOfHearts);
        playerDeck.addCard(fourOfHearts);
        playerDeck.addCard(fiveOfHearts);
        playerDeck.addCard(sixOfHearts);

        playerDeck.selectCard(twoOfHearts);
        playerDeck.selectCard(threeOfHearts);
        playerDeck.selectCard(fourOfHearts);
        playerDeck.selectCard(fiveOfHearts);
        playerDeck.selectCard(sixOfHearts);

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
        Card tenOfHearts = new Heart("10", new Score(10), new Score(1));
        Card jackOfHearts = new Heart("Jota", new Score(10), new Score(1));
        Card queenOfHearts = new Heart("Reina", new Score(10), new Score(1));
        Card kingOfHearts = new Heart("Rey", new Score(10), new Score(1));
        Card aceOfHearts = new Heart("As", new Score(10), new Score(1));
        playerDeck.addCard(tenOfHearts);
        playerDeck.addCard(jackOfHearts);
        playerDeck.addCard(queenOfHearts);
        playerDeck.addCard(kingOfHearts);
        playerDeck.addCard(aceOfHearts);

        playerDeck.selectCard(tenOfHearts);
        playerDeck.selectCard(jackOfHearts);
        playerDeck.selectCard(queenOfHearts);
        playerDeck.selectCard(kingOfHearts);
        playerDeck.selectCard(aceOfHearts);

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
        Card twoOfHearts = new Heart("2", new Score(2), new Score(1));
        Card threeOfHearts = new Heart("3", new Score(3), new Score(1));
        Card kingOfSpades = new Spade("Rey", new Score(10), new Score(1));
        Card fiveOfHearts = new Heart("5", new Score(5), new Score(1));
        Card aceOfHearts = new Heart("As", new Score(10), new Score(1));
        playerDeck.addCard(twoOfHearts);
        playerDeck.addCard(threeOfHearts);
        playerDeck.addCard(kingOfSpades);
        playerDeck.addCard(fiveOfHearts);
        playerDeck.addCard(aceOfHearts);

        playerDeck.selectCard(twoOfHearts);
        playerDeck.selectCard(threeOfHearts);
        playerDeck.selectCard(kingOfSpades);
        playerDeck.selectCard(fiveOfHearts);
        playerDeck.selectCard(aceOfHearts);

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
        PlayerDeck secondPlayerDeck = new PlayerDeck();
        Card fiveOfHearts = new Heart("5", new Score(5), new Score(1));
        Card sixOfHearts = new Heart("6", new Score(6), new Score(1));
        Card sevenOfHearts = new Heart("7", new Score(7), new Score(1));
        Card eightOfHearts = new Heart("8", new Score(8), new Score(1));
        Card nineOfHearts = new Heart("9", new Score(9), new Score(1));

        firstPlayerDeck.addCard(fiveOfHearts);
        firstPlayerDeck.addCard(sixOfHearts);
        firstPlayerDeck.addCard(sevenOfHearts);
        firstPlayerDeck.addCard(eightOfHearts);
        firstPlayerDeck.addCard(nineOfHearts);

        secondPlayerDeck.addCard(fiveOfHearts);
        secondPlayerDeck.addCard(sixOfHearts);
        secondPlayerDeck.addCard(sevenOfHearts);
        secondPlayerDeck.addCard(eightOfHearts);
        secondPlayerDeck.addCard(nineOfHearts);
        // Act
        firstPlayerDeck.selectCard(fiveOfHearts);
        firstPlayerDeck.selectCard(sixOfHearts);
        firstPlayerDeck.selectCard(sevenOfHearts);
        firstPlayerDeck.selectCard(eightOfHearts);
        firstPlayerDeck.selectCard(nineOfHearts);

        Score firstScore = firstPlayerDeck.play(new ArrayList<>());

        secondPlayerDeck.selectCard(sevenOfHearts);
        secondPlayerDeck.selectCard(nineOfHearts);
        secondPlayerDeck.selectCard(sixOfHearts);
        secondPlayerDeck.selectCard(eightOfHearts);
        secondPlayerDeck.selectCard(fiveOfHearts);

        Score secondScore = secondPlayerDeck.play(new ArrayList<>());
        // Assert
        assertEquals(firstScore, secondScore);
    }
}

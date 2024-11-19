package model;

import model.cards.Card;
import org.junit.jupiter.api.Test;

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
        playerDeck.addCard(new Card(2, "heart"));
        playerDeck.addCard(new Card(8, "spade"));
        playerDeck.addCard(new Card(3, "heart"));
        playerDeck.addCard(new Card(4, "spade"));
        playerDeck.addCard(new Card(8, "heart"));
        playerDeck.addCard(new Card(11, "spade"));
        playerDeck.addCard(new Card(5, "spade"));
        playerDeck.addCard(new Card(7, "heart"));
        playerDeck.selectCard(1);
        playerDeck.selectCard(4);
        playerDeck.selectCard(3);
        playerDeck.selectCard(2);
        playerDeck.selectCard(7);
        Score expectedScore = new Score(52, 1);
        // Act
        Score obtainedScore = playerDeck.playSelectedCards();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test03WhenPlayingADoublePairItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Card(2, "heart"));
        playerDeck.addCard(new Card(8, "spade"));
        playerDeck.addCard(new Card(3, "heart"));
        playerDeck.addCard(new Card(2, "spade"));
        playerDeck.addCard(new Card(8, "heart"));
        playerDeck.addCard(new Card(11, "spade"));
        playerDeck.addCard(new Card(5, "spade"));
        playerDeck.addCard(new Card(7, "heart"));
        playerDeck.selectCard(0);
        playerDeck.selectCard(4);
        playerDeck.selectCard(3);
        playerDeck.selectCard(1);
        playerDeck.selectCard(7);
        Score expectedScore = new Score(80, 1);
        // Act
        Score obtainedScore = playerDeck.playSelectedCards();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }
    @Test
    public void test04WhenPlayingAThreeOfAKindItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Card(2, "heart"));
        playerDeck.addCard(new Card(8, "spade"));
        playerDeck.addCard(new Card(8, "diamond"));
        playerDeck.addCard(new Card(4, "spade"));
        playerDeck.addCard(new Card(8, "heart"));
        playerDeck.addCard(new Card(11, "spade"));
        playerDeck.addCard(new Card(5, "spade"));
        playerDeck.addCard(new Card(7, "heart"));
        playerDeck.selectCard(1);
        playerDeck.selectCard(4);
        playerDeck.selectCard(3);
        playerDeck.selectCard(2);
        playerDeck.selectCard(7);
        Score expectedScore = new Score(162, 1);
        // Act
        Score obtainedScore = playerDeck.playSelectedCards();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test05WhenPlayingAStraightItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Card(2, "heart"));
        playerDeck.addCard(new Card(7, "spade"));
        playerDeck.addCard(new Card(3, "diamond"));
        playerDeck.addCard(new Card(4, "spade"));
        playerDeck.addCard(new Card(5, "heart"));
        playerDeck.addCard(new Card(6, "spade"));
        playerDeck.addCard(new Card(5, "spade"));
        playerDeck.addCard(new Card(7, "heart"));
        playerDeck.selectCard(5);
        playerDeck.selectCard(1);
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(4);
        Score expectedScore = new Score(220, 1);
        // Act
        Score obtainedScore = playerDeck.playSelectedCards();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test06WhenPlayingAFlushItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Card(2, "heart"));//0
        playerDeck.addCard(new Card(7, "spade"));//1
        playerDeck.addCard(new Card(3, "spade"));//2
        playerDeck.addCard(new Card(4, "spade"));//3
        playerDeck.addCard(new Card(5, "spade"));//4
        playerDeck.addCard(new Card(8, "spade"));//5
        playerDeck.addCard(new Card(5, "spade"));//6
        playerDeck.addCard(new Card(7, "heart"));//7
        playerDeck.selectCard(5);
        playerDeck.selectCard(1);
        playerDeck.selectCard(4);
        playerDeck.selectCard(3);
        playerDeck.selectCard(2);
        Score expectedScore = new Score(248, 1);
        // Act
        Score obtainedScore = playerDeck.playSelectedCards();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test07WhenPlayingAFullHouseItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Card(2, "heart"));//0
        playerDeck.addCard(new Card(5, "diamond"));//1
        playerDeck.addCard(new Card(3, "heart"));//2
        playerDeck.addCard(new Card(3, "spade"));//3
        playerDeck.addCard(new Card(5, "spade"));//4
        playerDeck.addCard(new Card(8, "spade"));//5
        playerDeck.addCard(new Card(5, "club"));//6
        playerDeck.addCard(new Card(7, "heart"));//7
        playerDeck.selectCard(6);
        playerDeck.selectCard(1);
        playerDeck.selectCard(4);
        playerDeck.selectCard(3);
        playerDeck.selectCard(2);
        Score expectedScore = new Score(244, 1);
        // Act
        Score obtainedScore = playerDeck.playSelectedCards();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test08WhenPlayingAFourOfAKindItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Card(2, "heart"));//0
        playerDeck.addCard(new Card(5, "diamond"));//1
        playerDeck.addCard(new Card(5, "heart"));//2
        playerDeck.addCard(new Card(3, "spade"));//3
        playerDeck.addCard(new Card(5, "spade"));//4
        playerDeck.addCard(new Card(8, "spade"));//5
        playerDeck.addCard(new Card(5, "club"));//6
        playerDeck.addCard(new Card(7, "heart"));//7
        playerDeck.selectCard(6);
        playerDeck.selectCard(1);
        playerDeck.selectCard(4);
        playerDeck.selectCard(3);
        playerDeck.selectCard(2);
        Score expectedScore = new Score(560, 1);
        // Act
        Score obtainedScore = playerDeck.playSelectedCards();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test09WhenPlayingAStraightFlushItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Card(6, "heart"));//0
        playerDeck.addCard(new Card(5, "diamond"));//1
        playerDeck.addCard(new Card(5, "heart"));//2
        playerDeck.addCard(new Card(7, "heart"));//3
        playerDeck.addCard(new Card(5, "spade"));//4
        playerDeck.addCard(new Card(8, "heart"));//5
        playerDeck.addCard(new Card(9, "heart"));//6
        playerDeck.addCard(new Card(2, "heart"));//7
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(5);
        playerDeck.selectCard(6);
        playerDeck.selectCard(0);
        Score expectedScore = new Score(1080, 1);
        // Act
        Score obtainedScore = playerDeck.playSelectedCards();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test10WhenPlayingARoyalFlushItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Card(10, "heart"));//0
        playerDeck.addCard(new Card(5, "diamond"));//1
        playerDeck.addCard(new Card(14, "heart"));//2
        playerDeck.addCard(new Card(13, "heart"));//3
        playerDeck.addCard(new Card(5, "spade"));//4
        playerDeck.addCard(new Card(12, "heart"));//5
        playerDeck.addCard(new Card(11, "heart"));//6
        playerDeck.addCard(new Card(2, "heart"));//7
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(5);
        playerDeck.selectCard(6);
        playerDeck.selectCard(0);
        Score expectedScore = new Score(1280, 1);
        // Act
        Score obtainedScore = playerDeck.playSelectedCards();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test11WhenPlayingAHighCardItShouldGiveACertainScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Card(10, "heart"));//0
        playerDeck.addCard(new Card(5, "diamond"));//1
        playerDeck.addCard(new Card(14, "club"));//2
        playerDeck.addCard(new Card(3, "heart"));//3
        playerDeck.addCard(new Card(5, "spade"));//4
        playerDeck.addCard(new Card(12, "diamond"));//5
        playerDeck.addCard(new Card(11, "spade"));//6
        playerDeck.addCard(new Card(2, "heart"));//7
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(5);
        playerDeck.selectCard(6);
        playerDeck.selectCard(0);
        Score expectedScore = new Score(19, 1);
        // Act
        Score obtainedScore = playerDeck.playSelectedCards();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test12WhenPlayingATarotShouldModifyFinalScoreOfAHighCard() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Card(10, "heart"));
        playerDeck.addCard(new Card(5, "diamond"));
        playerDeck.addCard(new Card(14, "club"));
        playerDeck.addCard(new Card(3, "heart"));
        playerDeck.addCard(new Card(5, "spade"));
        playerDeck.addCard(new Card(12, "diamond"));
        playerDeck.addCard(new Card(11, "spade"));
        playerDeck.addCard(new Card(2, "heart"));
        Score expectedScore = new Score(21, 5);
        // Act
        Tarot tarot = new Tarot();
        tarot.setBehaviour(new ForValue());
        playerDeck.playTarot(2,tarot);
        tarot.setBehaviour(new ForMultiplier());
        playerDeck.playTarot(2,tarot);
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(5);
        playerDeck.selectCard(6);
        playerDeck.selectCard(0);
        Score obtainedScore = playerDeck.playSelectedCards();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test13VerifyThatTheOrderDoesNotChangeTheScore() {
        // Arrange
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Card(5, "heart"));
        playerDeck.addCard(new Card(6, "heart"));
        playerDeck.addCard(new Card(7, "heart"));
        playerDeck.addCard(new Card(8, "heart"));
        playerDeck.addCard(new Card(9, "heart"));
        playerDeck.addCard(new Card(2, "diamond"));
        playerDeck.addCard(new Card(6, "spade"));
        playerDeck.addCard(new Card(8, "spade"));
        // Act
        playerDeck.selectCard(0);
        playerDeck.selectCard(1);
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(4);
        Score score1 = playerDeck.playSelectedCards();
        playerDeck.cleanSelectedCards();
        playerDeck.selectCard(2);
        playerDeck.selectCard(4);
        playerDeck.selectCard(1);
        playerDeck.selectCard(3);
        playerDeck.selectCard(0);
        Score score2 = playerDeck.playSelectedCards();
        // Assert
        assertEquals(score1, score2);
    }
}

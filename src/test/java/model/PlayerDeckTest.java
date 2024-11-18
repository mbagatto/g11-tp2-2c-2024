package model;

import model.Cards.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerDeckTest {
    @Test
    public void playerDeckIsEmptyWhenInitializated() {
        PlayerDeck deck = new PlayerDeck();
        assertFalse(deck.isComplete());
    }
    @Test
    public void whenPlayingAPairItShouldGiveACertainScore() {

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
        Score obtainedScore = playerDeck.playSelectedCard();

        assertTrue(expectedScore.isEqualAs(obtainedScore));
    }
    @Test
    public void whenPlayingADoublePairItShouldGiveACertainScore() {
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
        Score obtainedScore = playerDeck.playSelectedCard();

        assertTrue(expectedScore.isEqualAs(obtainedScore));
    }
    @Test
    public void whenPlayingAThreeOfAKindItShouldGiveACertainScore() {
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
        Score obtainedScore = playerDeck.playSelectedCard();

        assertTrue(expectedScore.isEqualAs(obtainedScore));
    }

    @Test
    public void whenPlayingAStraightItShouldGiveACertainScore() {
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
        Score obtainedScore = playerDeck.playSelectedCard();

        assertTrue(expectedScore.isEqualAs(obtainedScore));
    }

    @Test
    public void whenPlayingAFlushItShouldGiveACertainScore() {
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
        Score obtainedScore = playerDeck.playSelectedCard();

        assertTrue(expectedScore.isEqualAs(obtainedScore));
    }

    @Test
    public void whenPlayingAFullHouseItShouldGiveACertainScore() {
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
        Score obtainedScore = playerDeck.playSelectedCard();

        assertTrue(expectedScore.isEqualAs(obtainedScore));
    }

    @Test
    public void whenPlayingAFourOfAKindItShouldGiveACertainScore() {
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
        Score obtainedScore = playerDeck.playSelectedCard();

        assertTrue(expectedScore.isEqualAs(obtainedScore));
    }

    @Test
    public void whenPlayingAStraightFlushItShouldGiveACertainScore() {
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
        Score obtainedScore = playerDeck.playSelectedCard();

        assertTrue(expectedScore.isEqualAs(obtainedScore));
    }

    @Test
    public void whenPlayingARoyalFlushItShouldGiveACertainScore() {
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
        Score obtainedScore = playerDeck.playSelectedCard();

        assertTrue(expectedScore.isEqualAs(obtainedScore));
    }

    @Test
    public void whenPlayingAHighCardItShouldGiveACertainScore() {
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
        Score obtainedScore = playerDeck.playSelectedCard();

        assertTrue(expectedScore.isEqualAs(obtainedScore));
    }

    @Test
    public void whenPlayingATarotShouldModifyFinalScoreOfAHighCard() {
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Card(10, "heart"));
        playerDeck.addCard(new Card(5, "diamond"));
        playerDeck.addCard(new Card(14, "club"));
        playerDeck.addCard(new Card(3, "heart"));
        playerDeck.addCard(new Card(5, "spade"));
        playerDeck.addCard(new Card(12, "diamond"));
        playerDeck.addCard(new Card(11, "spade"));
        playerDeck.addCard(new Card(2, "heart"));

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

        Score expectedScore = new Score(21, 5);
        Score obtainedScore = playerDeck.playSelectedCard();

        assertTrue(expectedScore.isEqualAs(obtainedScore));
    }

    @Test
    public void verifyThatTheOrderDoesNotChangeTheScore() {
        PlayerDeck playerDeck = new PlayerDeck();
        playerDeck.addCard(new Card(5, "heart"));
        playerDeck.addCard(new Card(6, "heart"));
        playerDeck.addCard(new Card(7, "heart"));
        playerDeck.addCard(new Card(8, "heart"));
        playerDeck.addCard(new Card(9, "heart"));
        playerDeck.addCard(new Card(2, "diamond"));
        playerDeck.addCard(new Card(6, "spade"));
        playerDeck.addCard(new Card(8, "spade"));

        playerDeck.selectCard(0);
        playerDeck.selectCard(1);
        playerDeck.selectCard(2);
        playerDeck.selectCard(3);
        playerDeck.selectCard(4);
        Score score1 = playerDeck.playSelectedCard();
        playerDeck.cleanSelectedCards();
        playerDeck.selectCard(2);
        playerDeck.selectCard(4);
        playerDeck.selectCard(1);
        playerDeck.selectCard(3);
        playerDeck.selectCard(0);
        Score score2 = playerDeck.playSelectedCard();

        assertTrue(score1.isEqualAs(score2));
    }
}

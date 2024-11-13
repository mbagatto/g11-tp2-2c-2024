import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerDeckTest {
    @Test
    public void playerDeckIsEmptyWhenInitializated() {
        PlayerDeck deck = new PlayerDeck();
        assertFalse(deck.isComplete());
    }
    @Test
    public void whenPlayingAPairItShouldGiveACertainScore(){

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
        int expectedScore = 52;
        Score score = playerDeck.playSelectedCard();

        assertEquals(score.calculateScore(),expectedScore);

    }

    @Test
    public void whenPlayingADoublePairItShouldGiveACertainScore(){

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
        int expectedScore = 80;
        Score score = playerDeck.playSelectedCard();

        assertEquals(score.calculateScore(),expectedScore);

    }

    @Test
    public void whenPlayingAThreeOfAKindItShouldGiveACertainScore(){

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
        int expectedScore = 162;
        Score score = playerDeck.playSelectedCard();

        assertEquals(score.calculateScore(),expectedScore);

    }

    @Test
    public void whenPlayingAStraightItShouldGiveACertainScore(){

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

        int expectedScore = 220;
        Score score = playerDeck.playSelectedCard();

        assertEquals(score.calculateScore(),expectedScore);

    }

    @Test
    public void whenPlayingAFlushItShouldGiveACertainScore(){

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
        int expectedScore = 248;
        Score score = playerDeck.playSelectedCard();

        assertEquals(score.calculateScore(),expectedScore);

    }

    @Test
    public void whenPlayingAFullHouseItShouldGiveACertainScore(){

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
        int expectedScore = 244;
        Score score = playerDeck.playSelectedCard();

        assertEquals(score.calculateScore(),expectedScore);

    }

    @Test
    public void whenPlayingAFourOfAKindItShouldGiveACertainScore(){

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
        int expectedScore = 560;
        Score score = playerDeck.playSelectedCard();

        assertEquals(score.calculateScore(),expectedScore);

    }

    @Test
    public void whenPlayingAStraightFlushItShouldGiveACertainScore(){

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
        int expectedScore = 1080;
        Score score = playerDeck.playSelectedCard();

        assertEquals(score.calculateScore(),expectedScore);

    }

    @Test
    public void whenPlayingARoyalFlushItShouldGiveACertainScore(){

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
        int expectedScore = 1280;
        Score score = playerDeck.playSelectedCard();

        assertEquals(score.calculateScore(),expectedScore);

    }

    @Test
    public void whenPlayingAHighCardItShouldGiveACertainScore(){

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
        int expectedScore = 19;
        Score score = playerDeck.playSelectedCard();

        assertEquals(score.calculateScore(),expectedScore);

    }

    @Test
    public void whenPlayingATarotShouldModifyFinalScoreOfAHighCard(){

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
        int expectedScore = 105;
        Score score = playerDeck.playSelectedCard();

        assertEquals(score.calculateScore(),expectedScore);

    }

}

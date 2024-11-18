package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {
    @Test
    public void heartMustBeHeart() {
        Card heartCard = new Card(13,"heart");
        Card expectedHeartCard = new Card(13,"heart");
        assertEquals(heartCard, expectedHeartCard);
    }
    @Test
    public void diamondMustBeDiamond() {
        Card diamondCard = new Card(13,"diamond");
        Card expectedDiamondCard = new Card(13,"diamond");
        assertEquals(diamondCard, expectedDiamondCard);
    }
    @Test
    public void spadeMustBeSpade() {
        Card spadeCard = new Card(13,"spade");
        Card expectedSpadeCard = new Card(13,"spade");
        assertEquals(spadeCard, expectedSpadeCard);
    }
    @Test
    public void clubMustBeClub() {
        Card clubCard = new Card(13,"club");
        Card expectedClubCard = new Card(13,"club");
        assertEquals(clubCard, expectedClubCard);
    }
    @Test
    public void heartMusntBeDiamond() {
        String heartSuit = "heart";
        int heartValue = 10;
        Card heartCard = new Card(heartValue,heartSuit);

        String clubSuit = "club";
        int clubValue = 5;
        Card clubCard = new Card(clubValue,clubSuit);

        assertFalse(heartCard.hasSameSuitAs(clubCard));
    }
    @Test
    public void CardScoreMustBe0() {
        String spadeSuit = "spade";
        int spadeValue = 2;
        Card spadeCard = new Card(spadeValue,spadeSuit);
        Score sumScore = new Score(0,0);
        spadeCard.addScoreTo(sumScore);
        int expectedValue = 2;
        assertEquals(spadeCard.calculateScore(), expectedValue);
    }
}

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
}

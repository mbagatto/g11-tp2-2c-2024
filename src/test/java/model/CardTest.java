package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardTest {
    @Test
    public void heartMustBeHeart() {
        Card heartCard = new Card(13,"heart");
        assertTrue(heartCard.isSuit("heart"));
    }
    @Test
    public void diamondMustBeDiamond() {
        Card diamondCard = new Card(13,"diamond");
        assertTrue(diamondCard.isSuit("diamond"));
    }
    @Test
    public void spadeMustBeSpade() {
        Card spadeCard = new Card(13,"spade");
        assertTrue(spadeCard.isSuit("spade"));
    }
    @Test
    public void clubMustBeClub() {
        Card clubCard = new Card(13,"club");
        assertTrue(clubCard.isSuit("club"));
    }
}

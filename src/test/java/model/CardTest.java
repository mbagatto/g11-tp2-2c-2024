package model;

import model.Cards.Card;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {
    @Test
    public void test01TwoHeartCardsMustBeEqual() {
        Card heartCard = new Card(13,"heart");
        Card otherHeartCard = new Card(13,"heart");
        assertEquals(heartCard, otherHeartCard);
    }

    @Test
    public void test02TwoDiamondCardsMustBeEqual() {
        Card diamondCard = new Card(11,"diamond");
        Card otherDiamondCard = new Card(11,"diamond");
        assertEquals(diamondCard, otherDiamondCard);
    }

    @Test
    public void test03TwoSpadeCardsMustBeEqual() {
        Card spadeCard = new Card(9,"spade");
        Card otherSpadeCard = new Card(9,"spade");
        assertEquals(spadeCard, otherSpadeCard);
    }

    @Test
    public void test04TwoClubCardsMustBeEqual() {
        Card clubCard = new Card(7,"club");
        Card otherClubCard = new Card(7,"club");
        assertEquals(clubCard, otherClubCard);
    }

    @Test
    public void test05TwoCardsWithDifferentSuitsMustNotBeEqual() {
        Card heartCard = new Card(5, "heart");
        Card clubCard = new Card(5, "club");
        assertNotEquals(heartCard, clubCard);
    }
}

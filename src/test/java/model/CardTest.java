package model;

import model.cards.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {
    @Test
    public void test01TwoHeartCardsMustBeEqual() {
        Card heartCard = new Heart(13);
        Card otherHeartCard = new Heart(13);
        assertEquals(heartCard, otherHeartCard);
    }

    @Test
    public void test02TwoDiamondCardsMustBeEqual() {
        Card diamondCard = new Diamond(11);
        Card otherDiamondCard = new Diamond(11);
        assertEquals(diamondCard, otherDiamondCard);
    }

    @Test
    public void test03TwoSpadeCardsMustBeEqual() {
        Card spadeCard = new Spade(9);
        Card otherSpadeCard = new Spade(9);
        assertEquals(spadeCard, otherSpadeCard);
    }

    @Test
    public void test04TwoClubCardsMustBeEqual() {
        Card clubCard = new Club(7);
        Card otherClubCard = new Club(7);
        assertEquals(clubCard, otherClubCard);
    }

    @Test
    public void test05TwoCardsWithDifferentSuitsMustNotBeEqual() {
        Card heartCard = new Heart(5);
        Card clubCard = new Club(5);
        assertNotEquals(heartCard, clubCard);
    }
}

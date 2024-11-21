package model;

import model.cards.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CardTest {
    @Test
    public void test01TwoHeartCardsMustBeEqual() {
        Card heartCard = new Heart("Rey de Corazones", "Rey", 10, 1);
        Card otherHeartCard = new Heart("Rey de Corazones", "Rey", 10, 1);
        assertEquals(heartCard, otherHeartCard);
    }

    @Test
    public void test02TwoDiamondCardsMustBeEqual() {
        Card diamondCard = new Diamond("Jota de Diamantes", "Jota", 10, 1);
        Card otherDiamondCard = new Diamond("Jota de Diamantes", "Jota", 10, 1);
        assertEquals(diamondCard, otherDiamondCard);
    }

    @Test
    public void test03TwoSpadeCardsMustBeEqual() {
        Card spadeCard = new Spade("9 de Picas", "9", 9, 1);
        Card otherSpadeCard = new Spade("9 de Picas", "9", 9, 1);
        assertEquals(spadeCard, otherSpadeCard);
    }

    @Test
    public void test04TwoClubCardsMustBeEqual() {
        Card clubCard = new Club("7 de Trebol", "7", 7, 1);
        Card otherClubCard = new Club("7 de Trebol", "7", 7, 1);
        assertEquals(clubCard, otherClubCard);
    }

    @Test
    public void test05TwoCardsWithDifferentSuitsMustNotBeEqual() {
        Card heartCard = new Heart("5 de Corazones", "5", 5, 1);
        Card clubCard = new Club("5 de Trebol", "5", 5, 1);
        assertNotEquals(heartCard, clubCard);
    }
}

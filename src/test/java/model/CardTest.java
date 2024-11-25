package model;

import model.cards.*;
import model.score.Score;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CardTest {
    @Test
    public void test01TwoHeartCardsMustBeEqual() {
        Card heartCard = new Heart("Rey", new Score(10), new Score(1));
        Card otherHeartCard = new Heart("Rey", new Score(10), new Score(1));
        assertEquals(heartCard, otherHeartCard);
    }

    @Test
    public void test02TwoDiamondCardsMustBeEqual() {
        Card diamondCard = new Diamond("Jota", new Score(10), new Score(1));
        Card otherDiamondCard = new Diamond("Jota", new Score(10), new Score(1));
        assertEquals(diamondCard, otherDiamondCard);
    }

    @Test
    public void test03TwoSpadeCardsMustBeEqual() {
        Card spadeCard = new Spade("9", new Score(9), new Score(1));
        Card otherSpadeCard = new Spade("9", new Score(9), new Score(1));
        assertEquals(spadeCard, otherSpadeCard);
    }

    @Test
    public void test04TwoClubCardsMustBeEqual() {
        Card clubCard = new Club("7", new Score(7), new Score(1));
        Card otherClubCard = new Club("7", new Score(7), new Score(1));
        assertEquals(clubCard, otherClubCard);
    }

    @Test
    public void test05TwoCardsWithDifferentSuitsMustNotBeEqual() {
        Card heartCard = new Heart("5", new Score(5), new Score(1));
        Card clubCard = new Club("5", new Score(5), new Score(1));
        assertNotEquals(heartCard, clubCard);
    }

    @Test
    public void test06TwoCardsWithDifferentNumbersMustNotBeEqual() {
        Card heartCard = new Heart("5", new Score(5), new Score(1));
        Card otherHeartCard = new Heart("6", new Score(6), new Score(1));
        assertNotEquals(heartCard, otherHeartCard);
    }
}

package model;

import model.cards.*;
import model.hands.*;
import model.cards.Card;
import model.score.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandTest {
    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        Field instance = HighCard.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        instance = Pair.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        instance = TwoPair.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        instance = ThreeOfAKind.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        instance = Straight.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        instance = Flush.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        instance = FullHouse.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        instance = FourOfAKind.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        instance = StraightFlush.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
        instance = RoyalFlush.class.getDeclaredField("instance");
        instance.setAccessible(true);
        instance.set(null, null);
    }

    @Test
    public void test01APairCalculatesItsScoreCorrectly() {
        // Arrange
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart("3", new Score(3), new Score(1)));
        cards.add(new Spade("3", new Score(3), new Score(1)));
        Hand pair = Pair.getInstance();
        Score expectedScore = new Score(32);
        // Act
        Score obtainedScore = pair.calculateScore(cards, new ArrayList<>());
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test02AHighCardIsEqualToOtherHighCard() {
        Hand highCard = HighCard.getInstance();
        Hand otherHighCard = HighCard.getInstance();
        assertEquals(highCard, otherHighCard);
    }

    @Test
    public void test03APairIsEqualToOtherPair() {
        Hand pair = Pair.getInstance();
        Hand otherPair = Pair.getInstance();
        assertEquals(pair, otherPair);
    }

    @Test
    public void test04ATwoPairIsEqualToOtherTwoPair() {
        Hand twoPair = TwoPair.getInstance();
        Hand otherTwoPair = TwoPair.getInstance();
        assertEquals(twoPair, otherTwoPair);
    }

    @Test
    public void test05AThreeOfAKindIsEqualToOtherThreeOfAKind() {
        Hand threeOfAKind = ThreeOfAKind.getInstance();
        Hand otherThreeOfAKind = ThreeOfAKind.getInstance();
        assertEquals(threeOfAKind, otherThreeOfAKind);
    }

    @Test
    public void test06AStraightIsEqualToOtherStraight() {
        Hand straight = Straight.getInstance();
        Hand otherStraight = Straight.getInstance();
        assertEquals(straight, otherStraight);
    }

    @Test
    public void test07AFlushIsEqualToOtherFlush() {
        Hand flush = Flush.getInstance();
        Hand otherFlush = Flush.getInstance();
        assertEquals(flush, otherFlush);
    }

    @Test
    public void test08AFullHouseIsEqualToOtherFullHouse() {
        Hand fullHouse = FullHouse.getInstance();
        Hand otherFullHouse = FullHouse.getInstance();
        assertEquals(fullHouse, otherFullHouse);
    }

    @Test
    public void test09AFourOfAKindIsEqualToOtherFourOfAKind() {
        Hand fourOfAKind = FourOfAKind.getInstance();
        Hand otherFourOfAKind = FourOfAKind.getInstance();
        assertEquals(fourOfAKind, otherFourOfAKind);
    }

    @Test
    public void test10AStraightFlushIsEqualToOtherStraightFlush() {
        Hand straightFlush = StraightFlush.getInstance();
        Hand otherStraightFlush = StraightFlush.getInstance();
        assertEquals(straightFlush, otherStraightFlush);
    }

    @Test
    public void test11ARoyalFlushIsEqualToOtherRoyalFlush() {
        Hand royalFlush = RoyalFlush.getInstance();
        Hand otherRoyalFlush = RoyalFlush.getInstance();
        assertEquals(royalFlush, otherRoyalFlush);
    }
}
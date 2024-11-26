package model;

import model.cards.*;
import model.hands.*;
import model.cards.Card;
import model.score.Score;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandTest {
    @Test
    public void test01APairCalculatesItsScoreCorrectly() {
        // Arrange
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart("3", new Score(3), new Score(1)));
        cards.add(new Spade("3", new Score(3), new Score(1)));
        Hand pair = new Pair(cards);
        Score expectedScore = new Score(32);
        // Act
        Score obtainedScore = pair.calculateScore(new ArrayList<>());
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test02AHighCardIsEqualToOtherHighCard() {
        ArrayList<Card> cards = new ArrayList<>();
        Hand highCard = new HighCard(cards);
        Hand otherHighCard = new HighCard(cards);
        assertEquals(highCard, otherHighCard);
    }

    @Test
    public void test03APairIsEqualToOtherPair() {
        ArrayList<Card> cards = new ArrayList<>();
        Hand pair = new Pair(cards);
        Hand otherPair = new Pair(cards);
        assertEquals(pair, otherPair);
    }

    @Test
    public void test04ATwoPairIsEqualToOtherTwoPair() {
        ArrayList<Card> cards = new ArrayList<>();
        Hand twoPair = new TwoPair(cards);
        Hand otherTwoPair = new TwoPair(cards);
        assertEquals(twoPair, otherTwoPair);
    }

    @Test
    public void test05AThreeOfAKindIsEqualToOtherThreeOfAKind() {
        ArrayList<Card> cards = new ArrayList<>();
        Hand threeOfAKind = new ThreeOfAKind(cards);
        Hand otherThreeOfAKind = new ThreeOfAKind(cards);
        assertEquals(threeOfAKind, otherThreeOfAKind);
    }

    @Test
    public void test06AStraightIsEqualToOtherStraight() {
        ArrayList<Card> cards = new ArrayList<>();
        Hand straight = new Straight(cards);
        Hand otherStraight = new Straight(cards);
        assertEquals(straight, otherStraight);
    }

    @Test
    public void test07AFlushIsEqualToOtherFlush() {
        ArrayList<Card> cards = new ArrayList<>();
        Hand flush = new Flush(cards);
        Hand otherFlush = new Flush(cards);
        assertEquals(flush, otherFlush);
    }

    @Test
    public void test08AFullHouseIsEqualToOtherFullHouse() {
        ArrayList<Card> cards = new ArrayList<>();
        Hand fullHouse = new FullHouse(cards);
        Hand otherFullHouse = new FullHouse(cards);
        assertEquals(fullHouse, otherFullHouse);
    }

    @Test
    public void test09AFourOfAKindIsEqualToOtherFourOfAKind() {
        ArrayList<Card> cards = new ArrayList<>();
        Hand fourOfAKind = new FourOfAKind(cards);
        Hand otherFourOfAKind = new FourOfAKind(cards);
        assertEquals(fourOfAKind, otherFourOfAKind);
    }

    @Test
    public void test10AStraightFlushIsEqualToOtherStraightFlush() {
        ArrayList<Card> cards = new ArrayList<>();
        Hand straightFlush = new StraightFlush(cards);
        Hand otherStraightFlush = new StraightFlush(cards);
        assertEquals(straightFlush, otherStraightFlush);
    }

    @Test
    public void test11ARoyalFlushIsEqualToOtherRoyalFlush() {
        ArrayList<Card> cards = new ArrayList<>();
        Hand royalFlush = new RoyalFlush(cards);
        Hand otherRoyalFlush = new RoyalFlush(cards);
        assertEquals(royalFlush, otherRoyalFlush);
    }
}
package model;

import model.cards.*;
import model.score.Score;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardSorterTest {
    @Test
    public void test01AListOfCardsShouldBeSortedCorrectly() {
        // Arrange
        ArrayList<Card> cardsToSort = new ArrayList<>();
        cardsToSort.add(new Heart("Jota", new Score(10), new Score(1)));
        cardsToSort.add(new Diamond("5", new Score(5), new Score(1)));
        cardsToSort.add(new Heart("2", new Score(2), new Score(1)));
        cardsToSort.add(new Club("Reina", new Score(10), new Score(1)));
        cardsToSort.add(new Heart("Rey", new Score(10), new Score(1)));
        cardsToSort.add(new Diamond("3", new Score(3), new Score(1)));
        cardsToSort.add(new Spade("6", new Score(6), new Score(1)));
        cardsToSort.add(new Spade("8", new Score(8), new Score(1)));
        CardSorter cardSorter = new CardSorter(cardsToSort);
        ArrayList<Card> expectedSortedCards = new ArrayList<>();
        expectedSortedCards.add(new Heart("2", new Score(2), new Score(1)));
        expectedSortedCards.add(new Diamond("3", new Score(3), new Score(1)));
        expectedSortedCards.add(new Diamond("5", new Score(5), new Score(1)));
        expectedSortedCards.add(new Spade("6", new Score(6), new Score(1)));
        expectedSortedCards.add(new Spade("8", new Score(8), new Score(1)));
        expectedSortedCards.add(new Heart("Jota", new Score(10), new Score(1)));
        expectedSortedCards.add(new Club("Reina", new Score(10), new Score(1)));
        expectedSortedCards.add(new Heart("Rey", new Score(10), new Score(1)));
        // Act
        ArrayList<Card> sortedCards = cardSorter.sortCards();
        // Assert
        assertEquals(expectedSortedCards, sortedCards);
    }

    @Test
    public void test02ShouldFindTheMaxCardOfAListCorrectly() {
        // Arrange
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart("Jota", new Score(10), new Score(1)));
        cards.add(new Diamond("5", new Score(5), new Score(1)));
        cards.add(new Heart("2", new Score(2), new Score(1)));
        cards.add(new Club("Reina", new Score(10), new Score(1)));
        cards.add(new Heart("Rey", new Score(10), new Score(1)));
        cards.add(new Diamond("3", new Score(3), new Score(1)));
        cards.add(new Spade("6", new Score(6), new Score(1)));
        cards.add(new Spade("8", new Score(8), new Score(1)));
        CardSorter cardSorter = new CardSorter(cards);
        Card expectedCard = new Heart("Rey", new Score(10), new Score(1));
        // Act
        Card obtainedCard = cardSorter.findMax().getFirst();
        // Assert
        assertEquals(expectedCard, obtainedCard);
    }
}

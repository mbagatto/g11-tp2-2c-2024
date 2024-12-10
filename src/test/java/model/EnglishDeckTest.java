package model;

import model.cards.Card;
import model.cards.Heart;
import model.decks.EnglishDeck;
import model.exceptions.EmptyDeckException;
import model.score.Score;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class EnglishDeckTest {
    @Test
    public void test01DealMustThrowAnExceptionWhenIsEmpty() {
        EnglishDeck englishDeck = new EnglishDeck();
        assertThrows(EmptyDeckException.class, englishDeck::deal);
    }

    @Test
    public void test02ADeckThatDealtACardIsNotEqualToOtherDeckThatDidNotDeal() {
        // Arrange
        EnglishDeck englishDeck = new EnglishDeck();
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart("2", new Score(2), new Score(1)));
        englishDeck.fillDeck(cards);

        EnglishDeck otherEnglishDeck = new EnglishDeck();
        otherEnglishDeck.fillDeck(cards);
        // Act
        englishDeck.deal();
        // Assert
        assertNotEquals(englishDeck, otherEnglishDeck);
    }
}

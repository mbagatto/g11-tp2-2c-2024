package model;

import model.exceptions.EmptyDeckException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EnglishDeckTest {
    @Test
    public void test01DealMustThrowAnExceptionWhenIsEmpty() {
        EnglishDeck englishDeck = new EnglishDeck();
        assertThrows(EmptyDeckException.class, englishDeck::deal);
    }

    @Test
    public void test02ADeckThatDealtACardIsNotEqualToAFullDeck() {
        // Arrange
        EnglishDeck englishDeck = new EnglishDeck();
        englishDeck.fillDeck();

        EnglishDeck otherEnglishDeck = new EnglishDeck();
        otherEnglishDeck.fillDeck();
        // Act
        englishDeck.deal();
        // Assert
        assertNotEquals(englishDeck, otherEnglishDeck);
    }
}
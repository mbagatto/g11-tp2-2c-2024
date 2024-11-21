package model;

import model.cards.Card;
import model.cards.Heart;
import model.identifiers.FlushIdentifier;
import model.identifiers.HandIdentifier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlushIdentifierTest {
//    @Test
//    public void test01FlushIdentifierIdentifiesAFlushCorrectly() {
//        // Arrange
//        HandIdentifier handIdentifier = new FlushIdentifier(null);
//        ArrayList<Card> cards = new ArrayList<>();
//        cards.add(new Heart(2));
//        cards.add(new Heart(8));
//        cards.add(new Heart(7));
//        cards.add(new Heart(4));
//        cards.add(new Heart(10));
//        Hand expectedHand = new Hand(35, 4, cards);
//        // Act
//        Hand obtainedHand = handIdentifier.identify(cards);
//        // Assert
//        assertEquals(expectedHand, obtainedHand);
//    }

    @Test
    public void test01FlushIdentifierIdentifiesAFlushCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new FlushIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart("2 de Corazones", "2", 2, 1));
        cards.add(new Heart("8 de Corazones", "8", 8, 1));
        cards.add(new Heart("7 de Corazones", "7", 7, 1));
        cards.add(new Heart("4 de Corazones", "4", 4, 1));
        cards.add(new Heart("10 de Corazones", "10", 10, 1));
        Hand expectedHand = new Hand(35, 4, cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }

}

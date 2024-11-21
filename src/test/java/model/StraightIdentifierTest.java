package model;

import model.cards.*;
import model.identifiers.HandIdentifier;
import model.identifiers.StraightIdentifier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StraightIdentifierTest {
    /*
    @Test
    public void test01StraightIdentifierIdentifiesAStraightCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new StraightIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart(3));
        cards.add(new Spade(7));
        cards.add(new Club(5));
        cards.add(new Diamond(4));
        cards.add(new Heart(6));
        Hand expectedHand = new Hand(30, 4, cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }

     */

    @Test
    public void test01StraightIdentifierIdentifiesAStraightCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new StraightIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart("3 de Corazones","3",3,1));
        cards.add(new Spade("7 de Picas","7",7,1));
        cards.add(new Club("5 de Trebol","5",5,1));
        cards.add(new Diamond("4 de Diamante","4",4,1));
        cards.add(new Heart("6 de Corazones","6",6,1));
        Hand expectedHand = new Hand(30, 4, cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }

}

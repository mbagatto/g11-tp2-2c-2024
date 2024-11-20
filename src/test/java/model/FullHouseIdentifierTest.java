package model;

import model.cards.Card;
import model.cards.Club;
import model.cards.Heart;
import model.cards.Spade;
import model.hands.FullHouse;
import model.hands.Hand;
import model.identifiers.FullHouseIdentifier;
import model.identifiers.HandIdentifier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FullHouseIdentifierTest {
    @Test
    public void test01FullHouseIdentifierIdentifiesAFullHouseCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new FullHouseIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart(4));
        cards.add(new Spade(4));
        cards.add(new Club(4));
        cards.add(new Heart(10));
        cards.add(new Spade(10));
        Hand expectedHand = new FullHouse(cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}

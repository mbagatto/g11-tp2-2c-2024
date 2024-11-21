package model;

import model.cards.Card;
import model.cards.Club;
import model.cards.Heart;
import model.cards.Spade;
import model.identifiers.HandIdentifier;
import model.identifiers.ThreeOfAKindIdentifier;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ThreeOfAKindIdentifierTest {
    @Test
    public void test01ThreeOfAKindIdentifierIdentifiesAThreeOfAKindCorrectly() {
        // Arrange
        HandIdentifier handIdentifier = new ThreeOfAKindIdentifier(null);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Heart("3 de Corazones", "3", 3, 1));
        cards.add(new Spade("3 de Picas", "3", 3, 1));
        cards.add(new Club("3 de Trebol", "3", 3, 1));
        Hand expectedHand = new Hand(30, 3, cards);
        // Act
        Hand obtainedHand = handIdentifier.identify(cards);
        // Assert
        assertEquals(expectedHand, obtainedHand);
    }
}

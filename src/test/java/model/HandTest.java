package model;

import model.Cards.Card;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandTest {
    @Test
    public void test01APairCalculatesItsScoreCorrectly() {
        // Arrange
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(new Card(3, "heart"));
        cards.add(new Card(3, "spade"));
        Hand pair = new Hand(10, 2, cards);
        Score expectedScore = new Score(32, 1);
        // Act
        Score obtainedScore = pair.calculateScore();
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }
}

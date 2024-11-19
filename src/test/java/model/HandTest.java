package model;

import model.cards.Heart;
import model.cards.Spade;
import model.specialCards.Joker;
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
        cards.add(new Heart(3));
        cards.add(new Spade(3));
        Hand pair = new Hand(10, 2, cards);
        Score expectedScore = new Score(32, 1);
        ArrayList<Joker> jokers = new ArrayList<>();
        // Act
        Score obtainedScore = pair.calculateScore(jokers);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }
}

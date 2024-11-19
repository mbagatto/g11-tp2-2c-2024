package model;

import model.cards.Card;
import model.score.Score;
import model.specialCards.ForMultiplier;
import model.specialCards.ForValue;
import model.specialCards.Tarot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TarotTest {
    @Test
    public void test01ATarotChangesCardMultiplierToSixCorrectly() {
        // Arrange
        Tarot tarot = new Tarot();
        tarot.setBehaviour(new ForMultiplier(6));
        Card card = new Card(5, "heart");
        Score expectedScore = new Score(30, 1);
        // Act
        card.applyTarot(tarot);
        Score obtainedScore = new Score(card.calculateScore(), 1);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test02ATarotChangesHandPointsToTenCorrectly() {
        // Arrange
        Tarot tarot = new Tarot();
        tarot.setBehaviour(new ForValue());
        Card card = new Card(7, "spade");
        Score expectedScore = new Score(10, 1);
        // Act
        card.applyTarot(tarot);
        Score obtainedScore = new Score(card.calculateScore(), 1);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }
}

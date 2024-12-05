package model;

import model.score.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreModifierTest {
    @Test
    public void test01AddScoreModifierShouldAddToOtherScoreCorrectly() {
        // Arrange
        ScoreModifier addModifier = new Add(new Score(1));
        Score toAddScore = new Score(5);
        Score expectedScore = new Score(6);
        // Act
        Score obtainedScore = addModifier.modify(toAddScore);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test02MultiplyScoreModifierShouldMultiplyToOtherScoreCorrectly() {
        // Arrange
        ScoreModifier multiplyModifier = new Multiply(new Score(2));
        Score toMultiplyScore = new Score(5);
        Score expectedScore = new Score(10);
        // Act
        Score obtainedScore = multiplyModifier.modify(toMultiplyScore);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test03DoNotModifyScoreModifierShouldNotModifyOtherScore() {
        // Arrange
        ScoreModifier doNotModifier = new DoNotModify();
        Score toModifyScore = new Score(5);
        Score expectedScore = new Score(5);
        // Act
        Score obtainedScore = doNotModifier.modify(toModifyScore);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }

    @Test
    public void test03ChangeScoreModifierShouldChangeOtherScoreCorrectly() {
        // Arrange
        ScoreModifier changeModifier = new Change(new Score(10));
        Score toModifyScore = new Score(5);
        Score expectedScore = new Score(10);
        // Act
        Score obtainedScore = changeModifier.modify(toModifyScore);
        // Assert
        assertEquals(expectedScore, obtainedScore);
    }
}

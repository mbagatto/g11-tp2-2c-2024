package model;

import model.score.Score;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTest {
    @Test
    public void test01ScoreShouldBeEqualToAnotherScore() {
        Score score = new Score(10);
        Score otherScore = new Score(10);
        assertEquals(score, otherScore);
    }

    @Test
    public void test02ScoreShouldAddOtherScoreCorrectly() {
        // Arrange
        Score scoreToEvaluate = new Score(10);
        Score expectedScore = new Score(11);
        // Act
        scoreToEvaluate = scoreToEvaluate.addWith(new Score(1));
        // Assert
        assertEquals(expectedScore, scoreToEvaluate);
    }

    @Test
    public void test03ScoreShouldMultiplyOtherScoreCorrectly() {
        // Arrange
        Score scoreToEvaluate = new Score(5);
        Score expectedScore = new Score(20);
        // Act
        scoreToEvaluate = scoreToEvaluate.multiplyWith(new Score(4));
        // Arrange
        assertEquals(expectedScore, scoreToEvaluate);
    }
}

package model;

import model.score.Multiplier;
import model.score.Point;
import model.score.Score;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTest {
    @Test
    public void test01ScoreShouldBeEqualToAnotherScore() {
        Score score = new Score(10,2);
        Score otherScore = new Score(20, 1);
        assertEquals(score, otherScore);
    }

    @Test
    public void test02ScoreShouldAddOtherScoreCorrectly() {
        // Arrange
        Score scoreToEvaluate = new Score(10, 1);
        Score expectedScore = new Score(11, 2);
        // Act
        scoreToEvaluate.addScore(new Score(1, 1));
        // Assert
        assertEquals(expectedScore, scoreToEvaluate);
    }

    @Test
    public void test03ScoreShouldChangeItsMultiplierCorrectly() {
        // Arrange
        Score scoreToEvaluate = new Score(5, 1);
        Multiplier multiplier = new Multiplier(2);
        Score expectedScore = new Score(5, 2);
        // Act
        scoreToEvaluate.changeMultiplier(multiplier);
        // Arrange
        assertEquals(expectedScore, scoreToEvaluate);
    }
    @Test
    public void test04ScoreShouldChangeItsPointsCorrectly() {
        // Arrange
        Score scoreToEvaluate = new Score(10, 1);
        Point point = new Point(1);
        Score expectedScore = new Score(1, 1);
        // Act
        scoreToEvaluate.changePoint(point);
        // Assert
        assertEquals(expectedScore, scoreToEvaluate);
    }
}

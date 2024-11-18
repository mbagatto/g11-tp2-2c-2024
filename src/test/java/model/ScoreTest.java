package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ScoreTest {
    @Test
    public void scoreShouldBeEqualToAnotherScore() {
        Score score = new Score(10,2);
        int expectedFinalScore = 20;
        assertEquals(score.calculateScore(),expectedFinalScore);
    }
    @Test
    public void scoreShouldSumCorrectlyAnotherScore() {
        Score score = new Score(10);
        Score sumScore = new Score(1);
        score.addScore(sumScore);
        int expectedScore = 11;
        assertEquals(score.calculateScore(),expectedScore);
    }
    @Test
    public void scoreShouldChangeHisMultiplier() {
        Score score = new Score(5);
        Multiplier multiplier = new Multiplier(2);
        score.changeMultiplier(multiplier);
        int expectedMultiplier = 10;
        assertEquals(score.calculateScore(),expectedMultiplier);
    }
    @Test
    public void scoreShouldChangeHisPoint() {
        Score score = new Score(10);
        Point point = new Point(1);
        score.changePoint(point);
        int expectedScore = 1;
        assertEquals(score.calculateScore(),expectedScore);
    }
    @Test
    public void scoreShouldBeEqualsToAnotherScore() {
        Score score = new Score(10, 2);
        Score anotherScore = new Score(10, 2);
        assertTrue(score.isEqualAs(anotherScore));
    }
}

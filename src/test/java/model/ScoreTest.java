package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTest {

    @Test
    public void shouldBeEqualToACertainScore() {

        Score score = new Score(10,2);
        int expectedFinalScore = 20;
        assertEquals(score.calculateScore(),expectedFinalScore);
    }

}

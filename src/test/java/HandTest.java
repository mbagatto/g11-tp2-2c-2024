import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandTest {
    @Test
    public void verifyThatAHandCalculatesItsScoreCorrectly() {
        Hand pair = new Hand(10, 2);
        int expectedScore = 20;
        assertEquals(expectedScore, pair.calculateScore());
    }



}

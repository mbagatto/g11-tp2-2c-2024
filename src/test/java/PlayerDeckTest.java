import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class PlayerDeckTest {
    @Test
    public void playerDeckIsEmptyWhenInitializated() {
        PlayerDeck deck = new PlayerDeck();
        assertFalse(deck.isComplete());
    }
}

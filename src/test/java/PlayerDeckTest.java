import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerDeckTest {
    @Test
    public void playerDeckIsEmptyWhenInitializated() {
        PlayerDeck deck = new PlayerDeck();
        assertFalse(deck.isComplete());
    }
}

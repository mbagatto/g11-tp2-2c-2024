import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeckTest {
    @Test
    public void verifyThatDeckHas52Cards() {
        Deck deck = new Deck();
        assertTrue(deck.isReadyToPlay());
    }
}

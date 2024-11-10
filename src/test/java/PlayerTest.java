import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerTest {
    @Test
    public void playerHas8CardsAfterDealing() {
        Deck deck = new Deck();
        Player player = new Player("Matias", deck);
        player.completeDeck();
        assertTrue(player.hasEnoughCards());
    }
}

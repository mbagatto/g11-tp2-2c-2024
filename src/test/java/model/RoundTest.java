package model;

import model.cards.Card;
import model.cards.Heart;
import model.cards.Spade;
import model.decks.EnglishDeck;
import model.game.Round;
import model.game.Shop;
import model.score.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RoundTest {
    private ArrayList<Card> cards;
    private EnglishDeck deck;

    @BeforeEach
    public void setUp() {
        this.cards = new ArrayList<>();
        this.cards.add(new Heart("2", new Score(2), new Score(1)));
        this.cards.add(new Heart("3", new Score(3), new Score(1)));
        this.cards.add(new Heart("4", new Score(4), new Score(1)));
        this.cards.add(new Heart("5", new Score(5), new Score(1)));
        this.cards.add(new Heart("6", new Score(6), new Score(1)));
        this.cards.add(new Heart("7", new Score(7), new Score(1)));
        this.cards.add(new Heart("8", new Score(8), new Score(1)));
        this.cards.add(new Heart("9", new Score(9), new Score(1)));
        this.cards.add(new Spade("2", new Score(2), new Score(1)));
        this.cards.add(new Spade("3", new Score(3), new Score(1)));
        this.cards.add(new Spade("4", new Score(4), new Score(1)));
        this.cards.add(new Spade("5", new Score(5), new Score(1)));
        this.cards.add(new Spade("6", new Score(6), new Score(1)));
        this.cards.add(new Spade("7", new Score(7), new Score(1)));
        this.cards.add(new Spade("8", new Score(8), new Score(1)));
        this.cards.add(new Spade("9", new Score(9), new Score(1)));
        this.deck = new EnglishDeck();
        this.deck.fillDeck(this.cards);
    }

    @Test
    public void test01RoundShouldntWin() {
        Round round = new Round(1, new Score(1), new Score(1), new Score(3000), new Shop());
        Player player = new Player("Ricardo Fort", this.deck);
        player.completeDeck();
        player.selectCard(this.cards.getFirst());
        round.playHand(player);
        assertFalse(round.wonRound());
    }

    @Test
    public void test02RoundShouldWin() {
        Round round = new Round(1, new Score(1), new Score(1), new Score(20), new Shop());
        Player player = new Player("Moria Casan", this.deck);
        player.completeDeck();
        player.selectCard(this.cards.getFirst());
        player.selectCard(this.cards.get(8));
        round.playHand(player);
        assertTrue(round.wonRound());
    }

    @Test
    public void test03RoundShouldRanOutOfDiscards() {
        Round round = new Round(1, new Score(1), new Score(2), new Score(20), new Shop());
        Player player = new Player("Francesco Virgolini", this.deck);
        player.completeDeck();
        player.selectCard(this.cards.getFirst());
        round.discardHand(player);
        player.selectCard(this.cards.get(1));
        round.discardHand(player);
        player.selectCard(this.cards.get(2));
        round.discardHand(player);
        assertTrue(round.ranOutOfDiscards());
    }

    @Test
    public void test04RoundShouldntRanOutOfDiscards() {
        Round round = new Round(1, new Score(1), new Score(2), new Score(20), new Shop());
        Player player = new Player("Polino", this.deck);
        player.completeDeck();
        player.selectCard(this.cards.getFirst());
        round.discardHand(player);
        assertFalse(round.ranOutOfDiscards());
    }

    @Test
    public void test05RoundShouldRanOutOfHands() {
        Round round = new Round(1, new Score(1), new Score(2), new Score(20), new Shop());
        Player player = new Player("Francesco Virgolini", this.deck);
        player.completeDeck();
        player.selectCard(this.cards.getFirst());
        round.playHand(player);
        assertTrue(round.ranOutOfHands());
    }

    @Test
    public void test06RoundShouldntRanOutOfHands() {
        Round round = new Round(1, new Score(10), new Score(2), new Score(20), new Shop());
        Player player = new Player("Francesco Virgolini", this.deck);
        player.completeDeck();
        player.selectCard(this.cards.getFirst());
        round.playHand(player);
        assertFalse(round.ranOutOfHands());
    }
}

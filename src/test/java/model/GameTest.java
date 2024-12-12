package model;

import model.cards.Card;
import model.cards.Heart;
import model.cards.Spade;
import model.decks.EnglishDeck;
import model.game.Game;
import model.game.Round;
import model.game.Shop;
import model.score.Score;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameTest {
    private ArrayList<Card> cards;
    private EnglishDeck deck;
    private ArrayList<Round> rounds;

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
        this.rounds = new ArrayList<>();
    }

    @Test
    public void test01GameShouldWonGame() {
        this.deck = new EnglishDeck();
        this.deck.fillDeck(cards);
        Player player = new Player("Bartolito", this.deck);
        player.completeDeck();
        player.selectCard(cards.getFirst());
        Round round = new Round(1, new Score(1), new Score(1), new Score(1), new Shop());
        this.rounds.add(round);
        Game game = new Game(player, this.rounds);
        game.playHand();
        assertTrue(game.wonGame());
    }

    @Test
    public void test02GameShouldntWonGame() {
        this.deck = new EnglishDeck();
        this.deck.fillDeck(cards);
        Player player = new Player("Mickey", this.deck);
        player.completeDeck();
        player.selectCard(cards.getFirst());
        Round round = new Round(1, new Score(1), new Score(1), new Score(10000), new Shop());
        this.rounds.add(round);
        Game game = new Game(player, this.rounds);
        game.playHand();
        assertFalse(game.wonGame());
    }

    @Test
    public void test03GameShouldChangeRound() {
        this.deck = new EnglishDeck();
        this.deck.fillDeck(cards);
        Round round = new Round(1, new Score(1), new Score(1), new Score(1), new Shop());
        Round round2 = new Round(2, new Score(1), new Score(1), new Score(1), new Shop());
        this.rounds.add(round);
        this.rounds.add(round2);
        Player player = new Player("Chapo", this.deck);
        player.completeDeck();
        player.selectCard(cards.getFirst());
        Game game = new Game(player, this.rounds);
        game.playHand();
        game.setNextRound();
        assertFalse(game.wonGame());
    }
}

package model.game;

import model.Player;
import view.dtos.GameDTO;
import java.util.ArrayList;
import java.util.Iterator;

public class Game {
    private Player player;
    private Round currentRound;
    private Iterator<Round> roundIterator;

    public Game(Player player, ArrayList<Round> rounds) {
        this.player = player;
        this.roundIterator = rounds.iterator();
        this.currentRound = roundIterator.next();
    }

    public void playHand() {
        this.currentRound.playHand(this.player);
    }

    public void discardHand() {
        this.currentRound.discardHand(this.player);
    }

    public void setNextRound() {
        this.currentRound = roundIterator.next();
    }

    public void buildNewRound() {
        this.player.resetDiscards();
        this.player.resetDecks();
    }

    public void completePlayerDeck() {
        this.player.completeDeck();
    }

    public boolean wonRound() {
        return this.currentRound.wonRound();
    }

    public boolean wonGame() {
        return (this.currentRound.wonRound() && !this.roundIterator.hasNext());
    }

    public boolean ranOutOfHands() {
        return this.currentRound.ranOutOfHands();
    }

    public boolean ranOutOfDiscards() {
        return this.currentRound.ranOutOfDiscards();
    }

    public GameDTO toDTO() {
        return new GameDTO(this.player, this.currentRound);
    }
}

package model.game;

import model.Player;

import java.util.ArrayList;
import java.util.Iterator;

public class Game {
    private Player player;
    private Round currentRound;
    private Iterator<Round> roundIterator;

    public Game(Player player, ArrayList<Round> rounds) {
        this.player = player;
        this.currentRound = rounds.getFirst();
        this.roundIterator = rounds.iterator();
    }

    public void playHand() {
        this.currentRound.playHand(this.player);
        if (this.currentRound.wonRound()) {
            this.currentRound = roundIterator.next();
        }
    }

    public void playDiscard() {
        this.currentRound.discardHand(this.player);
    }

    public GameDTO toDTO() {
        return new GameDTO(this.player, this.currentRound);
    }
}

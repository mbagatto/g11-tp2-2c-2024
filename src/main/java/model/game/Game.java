package model.game;

import model.Player;

public class Game {
    private Player player;
    private Round currentRound;

    public Game(Player player, Round firstRound) {
        this.player = player;
        this.currentRound = firstRound;
    }

    public void playHand() {
        this.currentRound.playHand(this.player);
    }

    public void playDiscard() {
        this.currentRound.discardHand(this.player);
    }

    public GameDTO toDTO() {
        return new GameDTO(this.player, this.currentRound);
    }
}

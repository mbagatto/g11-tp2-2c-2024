package model.game;

import model.Player;

import java.util.ArrayList;

public class Game {
    private Player player;
    private ArrayList<Round> rounds;
    private Round currentRound;

    public Game(Player player, ArrayList<Round> rounds) {
        this.player = player;
        this.rounds = rounds;
        this.currentRound = rounds.getFirst();
    }

    public Round nextRound() {
        Round round = currentRound;
        this.currentRound = rounds.get(this.rounds.indexOf(currentRound) + 1);
        return round;
    }
}

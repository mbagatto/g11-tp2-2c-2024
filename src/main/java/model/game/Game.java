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
        //this.currentRound = rounds.getFirst();
        this.currentRound = null;
    }

    public Round nextRound() {
        if (this.currentRound == null) {
            this.currentRound = this.rounds.get(0);
            return this.currentRound;
        }
        int currentIndex = this.rounds.indexOf(this.currentRound);
        if (currentIndex == rounds.size() - 1) {
            return null;
        }
        this.currentRound = this.rounds.get(currentIndex + 1);
        return this.currentRound;
    }

}

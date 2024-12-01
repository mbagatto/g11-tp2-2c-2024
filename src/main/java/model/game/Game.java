package model.game;

import model.Player;

import java.util.ArrayList;

public class Game {
    private Player player;
    private ArrayList<Round> rounds;

    public Game(Player player) {
        this.player = player;
    }

    public void setRounds(ArrayList<Round> rounds) {
        this.rounds = rounds;
    }
}

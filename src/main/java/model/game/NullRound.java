package model.game;

import model.Player;

public class NullRound extends Round {
    @Override
    public void playHand(Player player) {}
    @Override
    public void discardHand(Player player) {}
}

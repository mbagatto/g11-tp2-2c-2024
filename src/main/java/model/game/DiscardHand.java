package model.game;

import model.Player;
import model.score.Score;

public class DiscardHand implements Turn {
    public Score playTurn(Player player) {
        player.discard();
        return new Score(0);
    }
}

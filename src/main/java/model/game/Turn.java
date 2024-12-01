package model.game;

import model.Player;
import model.score.Score;

public interface Turn {
    Score playTurn(Player player);
}

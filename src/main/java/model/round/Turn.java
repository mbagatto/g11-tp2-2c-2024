package model.round;

import model.Player;
import model.score.Score;

import java.util.Stack;

public interface Turn {
    Score playTurn(Player player);
}

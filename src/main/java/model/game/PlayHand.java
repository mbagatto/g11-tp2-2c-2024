package model.game;

import model.Player;
import model.score.Score;

public class PlayHand implements Turn {

    public Score playTurn(Player player){
        return player.play();
    }
}

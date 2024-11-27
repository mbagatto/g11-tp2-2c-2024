package model.round;

import model.Player;
import model.score.Score;

import java.util.Stack;

public class PlayHand implements Turn {

    public Score playTurn(Player player){

        Score score = player.play();

        return score;
    }



}

package model.round;

import model.Player;
import model.hands.Hand;
import model.score.Score;

import java.util.Stack;

public class DiscardHand implements Turn {


    public Score playTurn(Player player){
        player.discard();
        return new Score(0);
    }

}

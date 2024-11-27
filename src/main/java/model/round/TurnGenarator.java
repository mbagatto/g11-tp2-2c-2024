package model.round;

import java.util.Stack;

public class TurnGenarator {

    public Stack<PlayHand> GeneratePlayHands(int numbersOfTurns){
        Stack<PlayHand> turns = new Stack<>();
        for(int i = 0; i < numbersOfTurns; i++){
            turns.push(new PlayHand());
        }
        return turns;
    }

    public Stack<DiscardHand> GenerateDiscardHands(int numbersOfTurns){
        Stack<DiscardHand> turns = new Stack<>();
        for(int i = 0; i < numbersOfTurns; i++){
            turns.push(new DiscardHand());
        }
        return turns;
    }
}

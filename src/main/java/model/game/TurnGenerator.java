package model.game;

import model.score.Score;
import java.util.Stack;

public class TurnGenerator {
    public Stack<PlayHand> generatePlayHands(Score numbersOfTurns){
        Stack<PlayHand> turns = new Stack<>();
        for (int i = 0; i < numbersOfTurns.numericValue(); i++) {
            turns.push(new PlayHand());
        }
        return turns;
    }

    public Stack<DiscardHand> generateDiscardHands(Score numbersOfTurns){
        Stack<DiscardHand> turns = new Stack<>();
        for (int i = 0; i < numbersOfTurns.numericValue(); i++){
            turns.push(new DiscardHand());
        }
        return turns;
    }
}

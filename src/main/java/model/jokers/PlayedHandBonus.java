package model.jokers;

import model.hands.Hand;
import model.score.Score;

public class PlayedHandBonus extends Effect {
    private Hand hand;

    public PlayedHandBonus(Score score, Hand hand) {
        super(score);
        this.hand = hand;
    }

    public void apply(Hand hand) {
        if (this.hand.getClass() == hand.getClass()) {
            hand.multiplyMultiplier(this.score);
        }
    }
}

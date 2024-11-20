package model.jokers;

import model.hands.Hand;
import model.score.Score;

public class PlayedHandBonus extends Joker {
    private Hand hand;

    public PlayedHandBonus(String name, Score effect, Hand hand) {
        super(name, effect);
        this.hand = hand;
    }

    public void applyEffect(Hand hand) {
        if (this.hand.getClass() == hand.getClass()) {
            hand.multiplyMultiplier(this.effect);
        }
    }
}

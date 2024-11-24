package model.jokers;

import model.hands.Hand;
import model.score.Score;

public class PlayedHandBonus extends Joker {

    private Hand hand;

    public PlayedHandBonus(String name, Score effect, Hand hand) {
        super(name, effect);
        this.hand = hand;
    }

    public PlayedHandBonus(String name, String description, String activation, Score effect) {
        super(name, description, activation, effect);
    }

    public void applyEffect(Hand hand) {
        if (this.hand.getClass() == hand.getClass()) {
            hand.addJokerScore(this.effect);
        }
    }
}

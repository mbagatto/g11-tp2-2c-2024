package model.jokers;

import model.hands.Hand;

public class Joker {
    private String name;
    private Effect effect;

    public Joker(String name, Effect effect) {
        this.name = name;
        this.effect = effect;
    }

    public void applyEffect(Hand hand) {
        this.effect.apply(hand);
    }

//    public boolean hasEffect(Effect effect) {
//        return this.effect.equals(effect);
//    }

//    public void setDiscards(int discard) {
//        this.effect.setDiscards(discard);
//    }
}

package model.jokers;

import model.hands.Hand;
import model.score.Score;

import java.util.ArrayList;

public class Combinated extends Joker {
    private ArrayList<Joker> jokers;

    public Combinated(String nombre, ArrayList<Joker> jokers) {
        super(nombre);
        this.jokers = jokers;
    }

    public void applyEffect(Hand hand) {
        for (Joker joker : jokers) {
            joker.applyEffect(hand);
        }
    }
}

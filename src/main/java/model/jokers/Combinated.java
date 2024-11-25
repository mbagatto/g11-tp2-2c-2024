package model.jokers;

import model.hands.Hand;
import model.score.Score;

import java.util.ArrayList;

public class Combinated extends Joker {
    private ArrayList<Joker> jokers;

    public Combinated(String name, ArrayList<Joker> jokers) {
        super(name);
        this.jokers = jokers;
    }

    public Score applyToPoints(Score points, Hand hand) {
        for (Joker joker : jokers) {
            points = joker.applyToPoints(points, hand);
        }
        return points;
    }

    public Score applyToMultiplier(Score multiplier, Hand hand) {
        for (Joker joker : jokers) {
            multiplier = joker.applyToMultiplier(multiplier, hand);
        }
        return multiplier;
    }
}

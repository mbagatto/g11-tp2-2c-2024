package model.creators;

import model.hands.Hand;
import model.jokers.*;
import model.score.ScoreModifier;
import java.util.ArrayList;

public class JokerCreator {
    public Joker createForTheScore(String name, String description, ScoreModifier toPoints, ScoreModifier toMultiplier) {
        return new ForTheScore(name, description, toPoints, toMultiplier);
    }

    public Joker createPlayedHandBonus(String name, String description, ScoreModifier toPoints, ScoreModifier toMultiplier, Hand hand) {
        return new PlayedHandBonus(name, description, toPoints, toMultiplier, hand);
    }

    public Joker createDiscardBonus(String name, String description, ScoreModifier toPoints, ScoreModifier toMultiplier) {
        return new DiscardBonus(name, description, toPoints, toMultiplier);
    }

    public Joker createRandomActivation(String name, String description, ScoreModifier toPoints, ScoreModifier toMultiplier, Probability probability) {
        return new RandomActivation(name, description, toPoints, toMultiplier, probability);
    }

    public Joker createCombinated(String name, String description, ArrayList<Joker> jokers) {
        return new Combinated(name, description, jokers);
    }
}
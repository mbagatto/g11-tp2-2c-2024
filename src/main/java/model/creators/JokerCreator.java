package model.creators;

import model.jokers.*;
import model.score.Score;

import java.util.ArrayList;


public class JokerCreator {

    public Joker createForTheScore(String name, String description, String activation, int points, int multiplicator) {
        return new ForTheScore(name, description, activation, new Score(points, multiplicator));
    }

    public Joker createForMultiplierDB(String name, String description, String activation, int points, int multiplicator) {
        return new ForMultiplierDB(name, description, activation, new Score(points, multiplicator));
    }

    public Joker createForPointsDB(String name, String description, String activation, int points, int multiplicator) {
        return new ForPointsDB(name, description, activation, new Score(points, multiplicator));
    }

    public Joker createForMultiplierRA(String name, String description, String activation, int points, int multiplicator) {
        return new ForMultiplierRA(name, description, activation, new Score(points, multiplicator));
    }

    public Joker createForPointsRA(String name, String description, String activation, int points, int multiplicator) {
        return new ForPointsRA(name, description, activation, new Score(points, multiplicator));
    }

    public Joker createPlayedHandBonus(String name, String description, String activation, int points, int multiplicator) {
        return new PlayedHandBonus(name, description, activation, new Score(points, multiplicator));
    }

    public Joker createCombinated(String name, ArrayList<Joker> jokers) {
        return new Combinated(name, jokers);
    }
}
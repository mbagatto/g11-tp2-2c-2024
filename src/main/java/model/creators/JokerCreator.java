package model.creators;

import model.jokers.ForTheScore;
import model.jokers.Joker;
import model.score.Score;


public class JokerCreator {
    public Joker createForTheScore(String name, String description, String activation, int points, int multiplicator) {
        return new ForTheScore(name, description, activation, new Score(points, multiplicator));
    }
}
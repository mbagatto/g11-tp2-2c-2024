package model.jokers;

import model.hands.Hand;

import java.util.Random;

public class Probability {
    private int limit;
    private Random random;
    private RandomActivation randomJoker;

    public Probability(int limit) {
        this.limit = limit;
        this.random = new Random();
    }

    public boolean calculate() {
        int randomNumber = random.nextInt(limit);
        return (randomNumber == 0);
    }
}

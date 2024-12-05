package model.hands;

import model.cards.Card;
import model.cards.CardSorter;
import model.jokers.Joker;
import model.score.Score;

import java.util.ArrayList;

public class HighCard extends Hand {
    private static HighCard instance;

    private HighCard() {
        super(new Score(5), new Score(1));
        this.name = "High Card";
    }

    public static HighCard getInstance() {
        if (instance == null) {
            instance = new HighCard();
        }
        return instance;
    }

    @Override
    public Score calculateScore(ArrayList<Card> cards, ArrayList<Joker> jokers) {
        Score points = new Score(0).addWith(this.points);
        Score multiplier = new Score(0).addWith(this.multiplier);
        Card maxCard = findMaxCard(cards);
        points = points.addWith(maxCard.calculateScore());
        for (Joker joker : jokers) {
            points = joker.applyToPoints(points, this);
            multiplier = joker.applyToMultiplier(multiplier, this);
        }
        return points.multiplyWith(multiplier);
    }

    private Card findMaxCard(ArrayList<Card> cards) {
        CardSorter sorter = new CardSorter(cards);
        return sorter.findMax();
    }
}

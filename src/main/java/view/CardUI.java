package view;

import model.ObservableCard;
import model.ObserverCard;
import model.score.Score;

public class CardUI implements ObserverCard {
    ObservableCard card;
    private String number;
    private Score points;
    private Score multiplier;
    private String suit;

    CardUI (ObservableCard card) {
        this.card = card;
        this.number = this.card.getNumber();
        this.points = this.card.getPoints();
        this.multiplier = this.card.getMultiplier();
        this.suit = this.card.getSuit();
    }

    @Override
    public void update() {
        this.number = this.card.getNumber();
        this.points = this.card.getPoints();
        this.multiplier = this.card.getMultiplier();
        this.suit = this.card.getSuit();
    }
}

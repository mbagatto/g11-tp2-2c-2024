package model.cards;

import model.score.Score;
import model.specialCards.Modifiable;

import java.util.Objects;

public abstract class Card implements Modifiable {

    protected int value;
    protected String suit;
    protected Score score;
    protected String number;
    protected String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(number, card.number) && suit.equals(card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, suit);
    }

    public Card(String name, String number, int value, int multiplier) {
        this.name = name;
        this.number = number;
        this.score = new Score(value , multiplier);
    }

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
        this.score = new Score(this.value , 0);
    }

    public Card(int value) {
        this.value = value;
        this.score = new Score(this.value , 0);
    }

    public int getValue() {
        return (this.value);
    }



    public String getSuit() {
        return (this.suit);
    }

    public boolean hasSameSuitAs(Card card) {
        return (this.suit.equals(card.getSuit()));
    }

    public int calculateScore() {
        return this.score.calculateScore();
    }

    public void addScoreTo(Score anotherScore) {
        if(this.score.multiplierIsOne()) {
            anotherScore.addOnlyThePoint(this.score);
        }else{
            anotherScore.addScore(this.score);
        }

    }

    public String getNumber() {
        return (this.number);
    }

    public boolean isNumber(String number) {
        return this.number.equals(number);
    }

    public void modifyByTarot(Score effect){
        this.score.addTarotScore(effect);
    }

    public void addScore(Score score) {
        this.score.addScore(score);
    }
}

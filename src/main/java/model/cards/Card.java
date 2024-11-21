package model.cards;

import model.score.Score;
import model.specialCards.Tarot;
import java.util.Objects;

public abstract class Card {
    protected int value;
    protected String suit;
    protected Score score;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return value == card.value && suit.equals(card.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, suit);
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

    public void applyTarot(Tarot tarot) {
        tarot.applyEffect(this.score);
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
        anotherScore.addScore(this.score);
    }
}

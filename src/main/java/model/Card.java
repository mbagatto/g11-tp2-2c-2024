package model;

public class Card {
    private int value;
    private String suit;
    private Score score;

    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
        this.score = new Score(this.value , 0);
    }

    public int getValue() {
        return (this.value);
    }

    public void applyTarot(Tarot tarot) {
        tarot.applyEfect(this.score);
    }

    public boolean isSuit(String suit) {
        return (this.suit.equals(suit));
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

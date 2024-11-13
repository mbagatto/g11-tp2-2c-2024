import java.util.ArrayList;

public class Hand {
    private int points;
    private int multiplier;
    private Score score;
    private ArrayList<Card> cards;

    public Hand(int points, int multiplier) {
        this.points = points;
        this.multiplier = multiplier;
        score = new Score(points, multiplier);
        this.cards = new ArrayList<>();
    }

    public Hand(int points, int multiplier, ArrayList<Card> cards) {
        this.points = points;
        this.multiplier = multiplier;
        this.cards = cards;
        this.score = new Score(points, multiplier);
    }

    public int calculateScore() {
        return (this.points * this.multiplier);
    }

    public void applyTarot(Tarot tarot){
        tarot.applyEfect(this.score);
    }

    public boolean isEqualAs(Hand obtainedHand) {
        if (obtainedHand == null) {
            return false;
        }
        return (this.getClass().equals(obtainedHand.getClass()));
    }


    public void addCard(Card card) {
        this.cards.add(card);
    }

    public Score calculateTotalScore(){

        for (Card card : cards) {
            card.addScoreTo(this.score);
        }

        return this.score;
    }

}

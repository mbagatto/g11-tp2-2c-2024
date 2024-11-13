import java.util.ArrayList;

public class Hand {
    private int points;
    private int multiplier;
    private Score score;

    public Hand(int points, int multiplier) {
        this.points = points;
        this.multiplier = multiplier;
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
}

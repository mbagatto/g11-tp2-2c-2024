import java.util.ArrayList;

public class HandCalculator {
    private HandPattern currentPattern;

    public void setPattern(HandPattern pattern) {
        this.currentPattern = pattern;
    }

    public boolean verifyPattern(ArrayList<Card> cards) {
        return (this.currentPattern.verifyPattern(cards));
    }
}

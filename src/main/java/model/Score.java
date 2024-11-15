package model;

public class Score {
    private int value;
    private int multiplier;

    private int getMultiplier() {
        return this.multiplier;
    }

    private int getValue() {
        return this.value;
    }

    public Score(int value, int multiplier) {
        this.value = value;
        this.multiplier = multiplier;
    }

    public int calculateScore() {
        if(this.multiplier == 0) {
            return this.value;
        }
        return value * multiplier;
    }

    public void addScore(Score otherValue) {
        this.value += otherValue.getValue();
        this.multiplier += otherValue.getMultiplier();
    }

    public void setValue(int otherValue){
         this.value = otherValue;
    }

    public void setMultiplier(int otherMultiplier){
        this.multiplier = otherMultiplier;
    }

    public boolean isEqualAs(Score otherScore) {
        return (this.calculateScore() == otherScore.calculateScore());
    }
}

public class Score {
    private int value;
    private int multiplier;

    private int getMultiplier() {
        return multiplier;
    }

    private int getValue() {
        return value;
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

    public void changeValue(int otherValue){
        this.setValue(otherValue);
    }

    public void changeMultiplier(int otherMultiplier){
        this.setMultiplier(otherMultiplier);
    }

    public void addScore(Score otherValue){
        this.value = this.value + otherValue.getValue();
        this.multiplier = this.multiplier + otherValue.getMultiplier();
    }

    private void setValue(int otherValue){
         this.value = otherValue;
    }

    private void setMultiplier(int otherMultiplier){
        this.multiplier = otherMultiplier;
    }


}

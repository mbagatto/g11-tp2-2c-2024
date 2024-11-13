public class Score {
    private int value;
    private int multiplier;

    public Score(int value, int multiplier) {
        this.value = value;
        this.multiplier = multiplier;
    }


    public int calculateScore() {
        return value * multiplier;
    }

    public void changeValue(int otherValue){
        this.setValue(otherValue);
    }

    public void changeMultiplier(int otherMultiplier){
        this.setMultiplier(otherMultiplier);
    }

    private void setValue(int otherValue){
         this.value = otherValue;
    }

    private void setMultiplier(int otherMultiplier){
        this.multiplier = otherMultiplier;
    }


}

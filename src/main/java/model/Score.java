package model;

public class Score {
//  private int value;
    private Point point;
    //private int multiplier;
    private Multiplier multiplier;

//    private int getMultiplier() {
//        return this.multiplier;
//    }

//    private int getValue() {
//        return this.value;
//    }

    public Score(int value, int multiplier) {
//      this.value = value;
        this.point = new Point(value);
        this.multiplier = new Multiplier(multiplier);
    }

    public Score(int value) {
        this.point = new Point(value);
        this.multiplier = new Multiplier();
    }

//    public int calculateScore() {
//        if(this.multiplier == 0) {
//            return this.value;
//        }
//        return value * multiplier;
//    }
    public int calculateScore() {
        if (this.multiplier.isZero()) {
            return this.point.multiplyBy(1);
        } else {
            return this.multiplier.applyMultiplierTo(this.point);
        }
    }

    public void addScore(Score otherValue) {
//        this.value += otherValue.getValue();
        this.point.add(otherValue.point);
        this.multiplier.add(otherValue.multiplier);
    }

//    public void setValue(int otherValue){
//         this.value = otherValue;
//    }

//    public void setMultiplier(int otherMultiplier){
//        this.multiplier = otherMultiplier;
//    }

    public void changeMultiplier (Multiplier otherMultiplier){
        this.multiplier.changeMultiplier(otherMultiplier);
    }

    public void changePoint (Point otherPoint){
        this.point.changePoint(otherPoint);
    }

    public boolean isEqualAs(Score otherScore) {
        return (this.calculateScore() == otherScore.calculateScore());
    }
}

package model.score;

import java.util.Objects;

public class Score {
    private Point point;
    private Multiplier multiplier;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return this.calculateScore() == score.calculateScore();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.calculateScore());
    }

    public Score(int value, int multiplier) {
        this.point = new Point(value);
        this.multiplier = new Multiplier(multiplier);
    }

    public Score(int value) {
        this.point = new Point(value);
        this.multiplier = new Multiplier();
    }

    public int calculateScore() {
        if (this.multiplier.isZero()) {
            return this.point.multiplyBy(1);
        } else {
            return this.multiplier.applyMultiplierTo(this.point);
        }
    }

    public void addScore(Score otherValue) {
        this.point.add(otherValue.point);
        this.multiplier.add(otherValue.multiplier);
    }

    public void addJokerScore(Score otherValue) {
        if (otherValue.multiplier.equals(new Multiplier(1))) {
            this.point.add(otherValue.point);
        } else {
            this.multiplier.add(otherValue.multiplier);
        }
    }

    public void changeMultiplier (Multiplier otherMultiplier){
        this.multiplier.changeMultiplier(otherMultiplier);
    }

    public void changePoint (Point otherPoint){
        this.point.changePoint(otherPoint);
    }

    public void addPoints(Score effect) {
        this.point.add(effect.point);
    }

    public boolean multiplierIsOne() {
        return this.multiplier.isOne();
    }
    public void addOnlyThePoint(Score otherValue) {
        this.point.add(otherValue.point);
    }
}

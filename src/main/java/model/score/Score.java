package model.score;

import java.util.Objects;

public class Score {
    private final double value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return value == score.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    public Score(double value) {
        this.value = value;
    }

    public Score addWith(Score otherScore) {
        return new Score(this.value + otherScore.value);
    }

    public Score multiplyWith(Score otherScore) {
        return new Score(this.value * otherScore.value);
    }

    public boolean isGreaterThanOrEqualTo(Score otherScore) {
        return this.value >= otherScore.value;
    }

    public int numericValue() {
        return (int) this.value;
    }
}

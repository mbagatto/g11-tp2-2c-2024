package model.score;

import java.util.Objects;

public class Multiplier {
    private int value;

    public Multiplier() {
        this.value = 0;
    }

    public Multiplier(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Multiplier multiplier = (Multiplier) o;
        return this.value == multiplier.value;
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(value);
    }

    public void add(Multiplier otherMultiplier) {
            this.value += otherMultiplier.value;
    }

    public boolean isZero() {
        return this.value == 1;
    }

    public boolean isOne() {
        return this.value == 1;
    }

    public int applyMultiplierTo(Point toMultiplier) {
        return toMultiplier.multiplyBy(this.value);
    }

    public void changeMultiplier(Multiplier otherMultiplier) {
        this.value = otherMultiplier.value;
    }

    public void multiply(Multiplier otherMultiplier) {
        this.value = this.value * otherMultiplier.value;
    }

}

package model;

import java.util.Objects;

public class Multiplier {

    private int value;

    public Multiplier(int value) {
        this.value = value;
    }

    public void add(Multiplier otherMultiplier) {
        this.value = this.value + otherMultiplier.value;
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Multiplier) {
            Multiplier multiplier = (Multiplier) o;
            return this.value == multiplier.value;
        }else{
            throw new IsNotAnInstanceOfMultiplierException();
        }
    }

    @Override
    public int hashCode(){
        return Objects.hash(value);
    }

    public boolean isZero() {
        return this.value == 0;
    }

    public int applyMultiplierTo(Point toMultiplier) {
        return toMultiplier.multiplyBy(this.value);
    }

    public void changeMultiplier(Multiplier otherMultiplier) {
        this.value = otherMultiplier.value;
    }
}

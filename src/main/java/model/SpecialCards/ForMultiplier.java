package model.SpecialCards;

import model.Multiplier;
import model.Score;

public class ForMultiplier implements Modifiable {
    int value;
    public ForMultiplier(int value) {
        this.value = value;
    }
    @Override
    public void apply(Score score) {
        score.changeMultiplier(new Multiplier(this.value));
    }
}

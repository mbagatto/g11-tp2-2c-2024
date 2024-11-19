package model.specialCards;

import model.score.Multiplier;
import model.score.Score;

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

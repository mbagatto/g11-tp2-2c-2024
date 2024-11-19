package model;

import model.specialCards.Modifiable;
import model.score.Multiplier;
import model.score.Score;

public class ForMultiplier implements Modifiable {
    @Override
    public void apply(Score score) {
        score.changeMultiplier(new Multiplier(6));
    }
}

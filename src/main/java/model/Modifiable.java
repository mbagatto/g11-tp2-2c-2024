package model;

import model.score.Score;

public interface Modifiable {
    void apply(Score score);
}

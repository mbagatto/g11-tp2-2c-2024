package model;

import model.score.ScoreModifier;

public interface Modifiable {
   void applyTarot(ScoreModifier points, ScoreModifier multiplier);
}

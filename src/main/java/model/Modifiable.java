package model;

import model.score.Score;
import model.score.ScoreModifier;

public abstract class Modifiable {
   protected Score points;
   protected Score multiplier;

   public Modifiable(Score points, Score multiplier) {
      this.points = points;
      this.multiplier = multiplier;
   }

   public boolean applyTarot(ScoreModifier toPoints, ScoreModifier toMultiplier) {
      Score oldPoints = new Score(this.points.numericValue());
      Score oldMultiplier = new Score(this.multiplier.numericValue());
      this.points = toPoints.modify(this.points);
      this.multiplier = toMultiplier.modify(this.multiplier);
      return (!oldPoints.equals(this.points) || !oldMultiplier.equals(this.multiplier));
   }
}

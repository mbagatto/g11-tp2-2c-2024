package model;

import model.cards.Card;
import model.score.Score;
import model.score.ScoreModifier;
import model.tarots.Tarot;

import java.util.ArrayList;

public abstract class Modifiable {
   protected Score points;
   protected Score multiplier;

   public Modifiable(Score points, Score multiplier) {
      this.points = points;
      this.multiplier = multiplier;
   }

   public void applyTarot(ScoreModifier toPoints, ScoreModifier toMultiplier, ArrayList<Card> selectedCards, Tarot tarot) {
      this.points = toPoints.modify(this.points);
      this.multiplier = toMultiplier.modify(this.multiplier);
   }
}

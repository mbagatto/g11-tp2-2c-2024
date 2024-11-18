package model.SpecialCards;

import model.Dealable;
import model.Score;

public class Joker extends Dealable {
    private Modifiable modifiable;

    public void setBehaviour(Modifiable modifiable) {
        this.modifiable = modifiable;
    }

    public void applyEfect(Score score){
        this.modifiable.apply(score);
    }
}

package model;

import model.score.Score;

public class Tarot {

    private Modifiable modifiable;

    public void setBehaviour(Modifiable modifiable) {
        this.modifiable = modifiable;
    }

    public void applyEfect(Score score){
        this.modifiable.apply(score);
    }
}

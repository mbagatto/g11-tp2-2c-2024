package model.tarots;

import model.Modifiable;
import model.Player;
import model.score.ScoreModifier;
import view.records.TarotDTO;

public class Tarot {
    private String name;
    private String description;
    private ScoreModifier toPoints;
    private ScoreModifier toMultiplier;
    private Modifiable target;

    public Tarot(String name, String description, ScoreModifier toPoints, ScoreModifier toMultiplier) {
        this.name = name;
        this.description = description;
        this.toPoints = toPoints;
        this.toMultiplier = toMultiplier;
    }

    public void setTarget(Modifiable target) {
        this.target = target;
    }

    public void apply(Player player) {
        if (this.target.applyTarot(this.toPoints, this.toMultiplier)) {

            player.removeTarot(this);
        }
    }

    public boolean hasName(String name) {
        return this.name.equals(name);
    }

    public TarotDTO toDTO() {
        return new TarotDTO(this.name, this.description);
    }
}

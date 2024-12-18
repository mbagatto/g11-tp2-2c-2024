package model.tarots;

import model.Modifiable;
import model.Player;
import model.cards.Card;
import model.cards.Heart;
import model.score.Score;
import model.score.ScoreModifier;
import view.dtos.TarotDTO;

import java.util.ArrayList;

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
        this.target = new Heart("2", new Score(2), new Score(1));
    }

    public void setTarget(Modifiable target) {
        this.target = target;
    }

    public void apply(Player player, ArrayList<Card> selectedCards) {
        this.target.applyTarot(this.toPoints, this.toMultiplier, selectedCards, this);
        player.removeTarot(this);
    }

    public boolean hasName(String name) {
        return this.name.equals(name);
    }

    public TarotDTO toDTO() {
        return new TarotDTO(this.name, this.description);
    }
}

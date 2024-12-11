package view;

import javafx.scene.Group;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Player;
import model.RoundObserver;
import model.decks.PlayerDeck;
import model.game.Round;
import view.records.PlayerDeckDTO;
import view.records.RoundDTO;

public class PlayerDeckContainer extends VBox implements RoundObserver {
    private Group previousScene;
    private Player player;
    private PlayerDeckDTO playerDeckDTO;

    public PlayerDeckContainer(Group previousScene, PlayerDeck playerDeck, Player player, Round actualRound, Stage stage) {
        this.previousScene = previousScene;
        this.setLayoutX(490);
        this.setLayoutY(650);
        this.setSpacing(25);
        actualRound.addObserver(this);
        this.player = player;
        this.playerDeckDTO = playerDeck.toDTO();
        this.getChildren().add(new PlayerDeckView(this.playerDeckDTO.cards(), this.player));
        this.getChildren().add(new PlayDiscardButtonsView(player, stage, actualRound));
    }

    @Override
    public void update(RoundDTO roundDTO) {
        this.getChildren().removeFirst();

        this.getChildren().addFirst(new PlayerDeckView(this.playerDeckDTO.cards(), this.player));

        this.previousScene.getChildren().remove(this);
        this.previousScene.getChildren().add(this);
    }
}

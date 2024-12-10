package view;

import javafx.scene.Group;
import javafx.scene.layout.VBox;
import model.Player;
import model.PlayerDeckObserver;
import model.decks.PlayerDeck;
import view.records.PlayerDeckDTO;

public class PlayerDeckContainer extends VBox implements PlayerDeckObserver {
    private Group stage;

    public PlayerDeckContainer(Group stage, PlayerDeck playerDeck, Player player) {
        this.stage = stage;
        this.setLayoutX(490);
        this.setLayoutY(650);
        this.setSpacing(25);
        playerDeck.addObserver(this);

        PlayerDeckDTO playerDeckDTO = playerDeck.toDTO();
        this.getChildren().add(new PlayerDeckView(playerDeckDTO.cards()));
    }

    @Override
    public void update(PlayerDeckDTO playerDeckDTO) {
        this.getChildren().clear();

        this.getChildren().add(new PlayerDeckView(playerDeckDTO.cards()));

        this.stage.getChildren().remove(this);
        this.stage.getChildren().add(this);
    }
}

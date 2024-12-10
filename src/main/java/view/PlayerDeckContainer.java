package view;

import javafx.scene.Group;
import javafx.scene.layout.VBox;
import model.Player;
import model.PlayerObserver;
import view.records.PlayerDTO;

public class PlayerDeckContainer extends VBox implements PlayerObserver {
    private Group stage;
    private Player player;
    public PlayerDeckContainer(Group stage, Player player) {
        this.stage = stage;
        this.player = player;
        player.addObserver(this);
        this.setLayoutX(500);
        this.setLayoutY(700);
        this.setSpacing(5);
        PlayerDeckView playerDeckView = new PlayerDeckView(this.player);
        this.getChildren().add(playerDeckView);

    }

    @Override
    public void update(PlayerDTO playerDTO) {
        this.getChildren().clear();
        this.getChildren().add(new PlayerDeckContainer(this.stage, this.player));
        this.stage.getChildren().remove(this);
        this.stage.getChildren().add(this);
    }
}

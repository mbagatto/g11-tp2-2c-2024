package view;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Player;
import view.buttons.ButtonPlay;
import view.buttons.ButtonQuit;

public class MenuButtonContainer extends HBox {

    public MenuButtonContainer(Stage stage, Player player) {
        super(12);
        this.setId("menu-button-container");
        this.setAlignment(Pos.CENTER);
        this.getChildren().add(new ButtonPlay(stage, player));
        this.getChildren().add(new ButtonQuit());
    }
}

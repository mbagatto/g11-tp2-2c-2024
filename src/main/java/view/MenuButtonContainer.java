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
        this.setAlignment(Pos.CENTER);
//        this.setStyle(
//                "-fx-background-color: rgba(0,0,0,0); "
//                + "-fx-padding: 14px; "
//                + "-fx-border-color: rgba(0,0,0,0); "
//                + "-fx-border-radius: 25px; "
//                + "-fx-border-width: 1px;"
//        );
        this.setStyle(
                "-fx-background-color: #38484D; " +
                        "-fx-background-radius: 25px; " +
                        "-fx-padding: 14px; " +
                        "-fx-border-color: #38484D; " +
                        "-fx-border-radius: 25px; " +
                        "-fx-border-width: 1px;"
        );
        this.getChildren().add(new ButtonPlay(stage, player));
        this.getChildren().add(new ButtonQuit());
    }
}

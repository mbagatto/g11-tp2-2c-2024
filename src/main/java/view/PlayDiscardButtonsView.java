package view;

import javafx.scene.Group;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.game.Game;
import view.buttons.ButtonDiscard;
import view.buttons.ButtonPlayHand;

public class PlayDiscardButtonsView extends HBox {
    
    public PlayDiscardButtonsView(Stage stage, Group previousScene, Game game, MainMenuView mainMenuView) {
        this.setSpacing(20);
        this.setTranslateX(300);
        this.getChildren().add(new ButtonPlayHand(stage, previousScene, game, mainMenuView));
        this.getChildren().add(new ButtonDiscard(game));
    }
}

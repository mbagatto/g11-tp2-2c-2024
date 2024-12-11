package view;

import javafx.scene.Group;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Player;
import model.game.Round;
import view.buttons.ButtonDiscard;
import view.buttons.ButtonPlayHand;

public class PlayDiscardButtonsView extends HBox {
    
    public PlayDiscardButtonsView(Stage stage, Group previousScene, Player player, Round actualRound) {
        this.setSpacing(20);
        this.setTranslateX(300);
        this.getChildren().add(new ButtonPlayHand(stage, previousScene, player, actualRound));
        this.getChildren().add(new ButtonDiscard(player, actualRound));
    }
}

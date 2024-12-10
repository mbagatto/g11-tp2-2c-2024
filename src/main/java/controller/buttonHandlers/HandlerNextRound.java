package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.game.GameDTO;
import view.MainMenuView;
import view.RoundGameView;

public class HandlerNextRound  implements EventHandler<ActionEvent> {
    private Stage stage;
    private MainMenuView mainMenuView;
    private GameDTO gameDTO;
    private SoundPlayer soundPlayer;

    public HandlerNextRound(Stage stage, MainMenuView mainMenuView, GameDTO gameDTO) {
        this.stage = stage;
        this.mainMenuView = mainMenuView;
        this.gameDTO = gameDTO;
        this.soundPlayer = SoundPlayer.getInstance();
    }

    public void handle(ActionEvent actionEvent) {
        this.soundPlayer.playButtonSound();

        //sujeto a cambios
        this.gameDTO.player().reorderDeck();
        this.gameDTO.player().shuffleDeck();
        this.gameDTO.player().completeDeck();


        Scene scene = new Scene(new RoundGameView(this.stage, this.mainMenuView, this.gameDTO));
        scene.getStylesheets().add("file:src/resources/custom-font-styles.css");
        stage.setScene(scene);
    }
}

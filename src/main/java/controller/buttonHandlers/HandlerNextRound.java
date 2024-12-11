package controller.buttonHandlers;

import controller.SoundPlayer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.game.Game;
import view.dtos.GameDTO;
import view.MainMenuView;
import view.RoundGameView;

public class HandlerNextRound  implements EventHandler<ActionEvent> {
    private Stage stage;
    private MainMenuView mainMenuView;
    private Game game;
    private SoundPlayer soundPlayer;

    public HandlerNextRound(Stage stage, MainMenuView mainMenuView, Game game) {
        this.stage = stage;
        this.mainMenuView = mainMenuView;
        this.game = game;
        this.soundPlayer = SoundPlayer.getInstance();
    }

    public void handle(ActionEvent actionEvent) {
        this.soundPlayer.playButtonSound();
        GameDTO gameDTO = this.game.toDTO();
        //sujeto a cambios
        gameDTO.player().reorderDeck();
        gameDTO.player().shuffleDeck();
        gameDTO.player().completeDeck();

        Scene scene = new Scene(new RoundGameView(this.stage, this.mainMenuView, this.game));
        scene.getStylesheets().add("file:src/resources/custom-font-styles.css");
        stage.setScene(scene);
    }
}

package view;

import controller.SoundPlayer;
import controller.buttonHandlers.HandlerActivateMusic;
import controller.buttonHandlers.HandlerDeactivateMusic;
import controller.buttonHandlers.HandlerMainMenuButton;
import controller.buttonHandlers.HandlerQuit;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.buttons.ButtonBlue;
import view.buttons.ButtonRed;
import view.buttons.ButtonYellow;

public class OptionsMenuView extends VBox {
    public OptionsMenuView(Stage stage, MainMenuView mainMenuView, PreparationView pView) {
        super();
        this.setStyle("-fx-background-color: rgba(0,0,0,0.9);");
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPrefSize(1920, 1080);

        Label title = new Label("Opciones");
        title.setStyle("-fx-text-fill: white; -fx-font-size: 92px;");

        VBox buttonContainer = new VBox();
        buttonContainer.setAlignment(Pos.CENTER);
        buttonContainer.setSpacing(10);

        Button continueButton = new ButtonYellow("Continuar");
        continueButton.setOnAction(_ -> pView.getChildren().removeLast());

        SoundPlayer soundPlayer = SoundPlayer.getInstance();

        Button modifyMusic = new ButtonYellow("");
        if (soundPlayer.isMusicPlaying()) {
            modifyMusic.setText("Desactivar Música");
            modifyMusic.setOnAction(new HandlerDeactivateMusic(modifyMusic, soundPlayer));
        } else {
            modifyMusic.setText("Activar Música");
            modifyMusic.setOnAction(new HandlerActivateMusic(modifyMusic, soundPlayer));
        }

        Button mainMenuButton = new ButtonBlue("Menú Principal");
        mainMenuButton.setPrefHeight(75);
        mainMenuButton.setOnAction(new HandlerMainMenuButton(stage, mainMenuView, pView));

        Button quitButton = new ButtonRed("Salir");
        quitButton.setPrefHeight(75);
        quitButton.setOnAction(new HandlerQuit());

        buttonContainer.getChildren().add(continueButton);
        buttonContainer.getChildren().add(modifyMusic);
        buttonContainer.getChildren().add(mainMenuButton);
        buttonContainer.getChildren().add(quitButton);

        this.getChildren().addAll(title, buttonContainer);
    }
}

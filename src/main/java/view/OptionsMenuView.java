package view;

import controller.buttonHandlers.HandlerMainMenuButton;
import controller.buttonHandlers.HandlerQuit;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.buttons.ButtonBlue;
import view.buttons.ButtonMusic;
import view.buttons.ButtonRed;
import view.buttons.ButtonYellow;

public class OptionsMenuView extends VBox {
    public OptionsMenuView(Stage stage, MainMenuView mainMenuView, Group groupView) {
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
        continueButton.setOnAction(_ -> groupView.getChildren().removeLast());

        Button mainMenuButton = new ButtonBlue("Menú Principal");
        mainMenuButton.setPrefHeight(75);
        mainMenuButton.setOnAction(new HandlerMainMenuButton(stage, mainMenuView, groupView));

        Button quitButton = new ButtonRed("Salir");
        quitButton.setPrefHeight(75);
        quitButton.setOnAction(new HandlerQuit());

        buttonContainer.getChildren().add(continueButton);
        buttonContainer.getChildren().add(mainMenuButton);
        buttonContainer.getChildren().add(quitButton);
        buttonContainer.getChildren().add(new ButtonMusic());

        this.getChildren().addAll(title, buttonContainer);
    }
}

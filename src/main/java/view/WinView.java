//package view;
//
//import controller.buttonHandlers.HandlerWin;
//import javafx.geometry.Pos;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.layout.VBox;
//import javafx.stage.Stage;
//import model.Player;
//import model.game.Game;
//import model.game.Round;
//import view.buttons.ButtonWin;
//
//public class WinView extends VBox {
//    public WinView(Stage stage) {
//        super();
//        this.setId("win-view");
//        this.setAlignment(Pos.CENTER);
//        this.setSpacing(10);
//
//        Label messageTitle = new Label("¡Felicidades! Has ganado el juego.");
//        messageTitle.setStyle("-fx-font-size: 90; -fx-text-fill: white");
//
//        Button win = new ButtonWin(stage);
//        win.setOnAction(new HandlerWin(stage));
//        this.getChildren().add(messageTitle);
//        this.getChildren().add(win);
//    }
//}

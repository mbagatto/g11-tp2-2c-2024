package view;

import javafx.application.Application;
import javafx.stage.Stage;


public class Interface extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("SOPA");
        stage.show();
    }

    public static void main(String[] args) { // Sin este main no funciona la interfaz
        launch(args);
    }

}

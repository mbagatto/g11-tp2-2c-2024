package view;


import controller.buttonHandlers.HandlerCardPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import model.Player;

import java.util.List;

public class CardPane extends StackPane {
     private int index;
     public CardPane(ImageView cardView) {

          this.setStyle(
                  "-fx-background-color: white; " +
                          "-fx-border-color: black; " +
                          "-fx-border-radius: 10; " +
                          "-fx-background-radius: 10;"
          );
          this.setPrefSize(160, 200); // esta es la parte blanca de la carta
          this.getChildren().add(cardView);
//          this.setOnMouseClicked(new HandlerCardPane());
     }
     CardPane(StackPane stackPane,int index,List<Integer> indexsCards, Player player) {
          super(stackPane);
          this.index = index;
          this.setOnMouseClicked(new HandlerCardPane(indexsCards, player));
     }

     public int getIndex() {
          return index;
     }
}

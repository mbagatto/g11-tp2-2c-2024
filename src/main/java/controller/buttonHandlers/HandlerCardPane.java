package controller.buttonHandlers;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.CardPane;
import view.PlayerObserver;

import java.util.List;

public class HandlerCardPane implements EventHandler<MouseEvent> {
    private Movable move;
    private List<Integer> indexs;
    private PlayerObserver playerObserver;

    public HandlerCardPane() {
        this.move = new CardPaneUp();
    }

    public HandlerCardPane(List<Integer> indexs) {
        this.move = new CardPaneUp();
        this.indexs = indexs;
        if(indexs.isEmpty()){
            System.out.println("esta vacia");
        }else{
            System.out.println("HandlerCardPane " + indexs.toString());
        }
        this.indexs = indexs;
    }

    public void handle(MouseEvent event){
        CardPane cardPane = (CardPane) event.getSource();
        if (this.indexs == null){
            System.out.println("es nulo en handle");
        } else{
            System.out.println("handle " + this.indexs.toString());
        }

        this.move.move(cardPane,this,this.indexs);
    }

    public void setMove(Movable move){
        this.move = move;
    }
}

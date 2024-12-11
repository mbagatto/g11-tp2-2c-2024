package view;

import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.Player;
import model.PlayerObserver;
import model.game.Shop;
import view.dtos.PlayerDTO;

public class PlayerJokersContainer extends VBox implements PlayerObserver {
    private Group stage;
    private Player player;
    private Shop shop;
    private JokersContainerView jokersContainerView;

    public PlayerJokersContainer(Group stage, Player player, Shop shop) {
        super();
        this.stage = stage;
        this.player = player;
        this.shop = shop;
        player.addObserver(this);
        PlayerDTO playerDTO = player.toDTO();

        this.setLayoutX(500);
        this.setLayoutY(100);
        this.setSpacing(5);

        this.jokersContainerView = new JokersContainerView(player, playerDTO.jokers(), shop);
        this.getChildren().add(jokersContainerView);

        Label jokersCount = new Label(playerDTO.jokers().size() + "/5");
        jokersCount.setId("player-jokers-count");
        this.getChildren().add(jokersCount);
    }

    @Override
    public void update(PlayerDTO playerDTO) {
        this.getChildren().clear();

        this.getChildren().add(new JokersContainerView(this.player, playerDTO.jokers(), this.shop));

        Label jokersCount = new Label(playerDTO.jokers().size() + "/5");
        jokersCount.setId("player-jokers-count");
        this.getChildren().add(jokersCount);

        this.stage.getChildren().remove(this);
        this.stage.getChildren().add(this);
    }

    public void setDisabledButtons() {
        this.jokersContainerView.setDisabledButtons();
    }
}

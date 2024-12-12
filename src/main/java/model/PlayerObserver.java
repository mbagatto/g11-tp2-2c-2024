package model;

import view.dtos.PlayerDTO;

public interface PlayerObserver {
    void update(PlayerDTO playerDTO);
}

package model;

import view.records.PlayerDTO;

public interface PlayerObserver {
    void update(PlayerDTO playerDTO);
}

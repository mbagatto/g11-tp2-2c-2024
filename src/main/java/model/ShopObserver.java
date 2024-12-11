package model;

import view.dtos.ShopDTO;

public interface ShopObserver {
    void update(ShopDTO shopDTO);
}

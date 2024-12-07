package model;

import view.records.ShopDTO;

public interface ShopObserver {
    void update(ShopDTO shopDTO);
}

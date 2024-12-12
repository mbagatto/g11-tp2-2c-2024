package model;

import view.dtos.EnglishCardDTO;

public interface CardObserver {
    void update(EnglishCardDTO cardDTO);
}

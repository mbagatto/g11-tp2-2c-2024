package model;

import view.dtos.EnglishDeckDTO;

public interface EnglishDeckObserver {
    void update(EnglishDeckDTO englishDeckDTO);
}

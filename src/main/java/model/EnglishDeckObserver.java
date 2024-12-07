package model;

import view.records.EnglishDeckDTO;

public interface EnglishDeckObserver {
    void update(EnglishDeckDTO englishDeckDTO);
}

package view.records;

import model.ClassDTO;

public record EnglishDeckDTO
        (
            int cardsCount
        ) implements ClassDTO {}

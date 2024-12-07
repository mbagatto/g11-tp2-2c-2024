package view.records;

import model.ClassDTO;

public record TarotDTO
        (
            String name,
            String description
        ) implements ClassDTO {}

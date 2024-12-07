package view.records;

import model.ClassDTO;

public record JokerDTO
        (
            String name,
            String description
        ) implements ClassDTO {}

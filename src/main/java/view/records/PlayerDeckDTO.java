package view.records;

import model.ClassDTO;

import java.util.ArrayList;

public record PlayerDeckDTO(ArrayList<EnglishCardDTO> cards, HandRecord handRecord) implements ClassDTO {
}

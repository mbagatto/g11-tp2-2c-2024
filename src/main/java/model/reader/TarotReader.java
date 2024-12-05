package model.reader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.tarots.Tarot;
import model.exceptions.CouldNotReadException;
import model.hands.*;
import model.score.Add;
import model.score.Change;
import model.score.DoNotModify;
import model.score.Score;
import java.io.File;
import java.util.ArrayList;

public class TarotReader implements Reader<Tarot> {
    private ArrayList<Tarot> tarots;

    public TarotReader() {
        this.tarots = new ArrayList<>();
    }

    public ArrayList<Tarot> read(String path) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(System.getProperty("user.dir") + path));
            JsonNode tarotsNode = rootNode.get("tarots");

            for (JsonNode tarotNode : tarotsNode) {
                String name = tarotNode.get("nombre").asText();
                String description = tarotNode.get("descripcion").asText();
                JsonNode effectNode = tarotNode.get("efecto");
                int points = effectNode.get("puntos").asInt();
                double multiplier = effectNode.get("multiplicador").asDouble();
                String ejemplar = tarotNode.get("ejemplar").asText();
                String appliesTo = tarotNode.get("sobre").asText();

                if (appliesTo.equals("carta") && !name.equals("El Tonto")) {
                    Tarot tarot = null;
                    if (points == 1) {
                        tarot = new Tarot(name, description, new DoNotModify(), new Change(new Score(multiplier)));
                    } else {
                        tarot = new Tarot(name, description, new Change(new Score(points)), new DoNotModify());
                    }
                    tarots.add(tarot);
                } else {
                    Tarot tarot = new Tarot(name, description, new Add(new Score(points)), new Add(new Score(multiplier)));
                    switch (ejemplar) {
                        case "cualquiera":
                            tarot.setTarget(HighCard.getInstance()); break;
                        case "par":
                            tarot.setTarget(Pair.getInstance()); break;
                        case "doble par":
                            tarot.setTarget(TwoPair.getInstance()); break;
                        case "trio":
                            tarot.setTarget(ThreeOfAKind.getInstance()); break;
                        case "escalera":
                            tarot.setTarget(Straight.getInstance()); break;
                        case "color":
                            tarot.setTarget(Flush.getInstance()); break;
                        case "full":
                            tarot.setTarget(FullHouse.getInstance()); break;
                        case "poker":
                            tarot.setTarget(FourOfAKind.getInstance()); break;
                        case "escalera de color":
                            tarot.setTarget(StraightFlush.getInstance()); break;
                        case "escalera real":
                            tarot.setTarget(RoyalFlush.getInstance()); break;
                    }
                    tarots.add(tarot);
                }
            }
        } catch (Exception e) {
            throw new CouldNotReadException();
        }
        return this.tarots;
    }
}

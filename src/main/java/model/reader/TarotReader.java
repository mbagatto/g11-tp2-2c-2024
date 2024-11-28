package model.reader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Tarot;
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

                if (ejemplar.equals("cualquiera")) {
                    if (points == 1) {
                        tarots.add(new Tarot(name, description, new DoNotModify(), new Change(new Score(multiplier))));
                    } else {
                        tarots.add(new Tarot(name, description, new Change(new Score(points)), new DoNotModify()));
                    }
                } else {
                    Tarot tarot = new Tarot(name, description, new Add(new Score(points)), new Add(new Score(multiplier)));
                    switch (ejemplar) {
                        case "par":
                            tarot.setTarget(Pair.getInstance());
                        case "doble par":
                            tarot.setTarget(TwoPair.getInstance());
                        case "trio":
                            tarot.setTarget(ThreeOfAKind.getInstance());
                        case "escalera":
                            tarot.setTarget(Straight.getInstance());
                        case "color":
                            tarot.setTarget(Flush.getInstance());
                        case "full":
                            tarot.setTarget(FullHouse.getInstance());
                        case "poker":
                            tarot.setTarget(FourOfAKind.getInstance());
                        case "escalera de color":
                            tarot.setTarget(StraightFlush.getInstance());
                        case "escalera real":
                            tarot.setTarget(RoyalFlush.getInstance());
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

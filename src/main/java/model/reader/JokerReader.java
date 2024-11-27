package model.reader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.creators.JokerCreator;
import model.exceptions.CouldNotReadException;
import model.hands.*;
import model.jokers.Joker;
import model.jokers.Probability;
import model.score.Add;
import model.score.DoNotModify;
import model.score.Multiply;
import model.score.Score;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class JokerReader implements Reader<Joker> {
    private final JokerCreator creator;

    public JokerReader() {
        this.creator = new JokerCreator();
    }

    public ArrayList<Joker> read() {
        ArrayList<Joker> jokers = new ArrayList<>();
        try {
            ObjectMapper mapper = new ObjectMapper();
            File from = new File(System.getProperty("user.dir") + "/cardsInfo/comodines.json");
            Map<String, JokerData> jsonData = mapper.readValue(from,
                    mapper.getTypeFactory().constructMapType(Map.class, String.class, JokerData.class));

            for (Map.Entry<String, JokerData> entry : jsonData.entrySet()) {
                entry.getValue().getJokers().forEach(joker -> {
                    String name = joker.getName();
                    String description = joker.getDescription();

                    if (entry.getKey().equals("Combinación")) {
                        ArrayList<Joker> combinatedJokers = new ArrayList<>();
                        for (JokerData internalJoker : joker.getJokers()) {
                            String internalJokerName = internalJoker.getName();
                            for (Joker j : jokers) {
                                if (j.hasName(internalJokerName)) {
                                    combinatedJokers.add(j);
                                }
                            }
                        }
                        jokers.add(this.creator.createCombinated(name, description, combinatedJokers));
                    } else {
                        int points = joker.getEffect().getPoints();
                        int multiplier = joker.getEffect().getMultiplier();

                        if (entry.getKey().equals("Al Puntaje")) {
                            if (points == 1) {
                                jokers.add(this.creator.createForTheScore(name, description, new DoNotModify(), new Multiply(new Score(multiplier))));
                            } else {
                                jokers.add(this.creator.createForTheScore(name, description, new Add(new Score(points)), new DoNotModify()));
                            }
                        }

                        if (entry.getKey().equals("Bonus por Mano Jugada")) {
                            JsonNode activation = joker.getActivation();
                            Hand hand = switch (activation.get("Mano Jugada").asText()) {
                                case "carta alta" -> HighCard.getInstance();
                                case "par" -> Pair.getInstance();
                                case "doble par" -> TwoPair.getInstance();
                                case "trio" -> ThreeOfAKind.getInstance();
                                case "escalera" -> Straight.getInstance();
                                case "color" -> Flush.getInstance();
                                case "full" -> FullHouse.getInstance();
                                case "poker" -> FourOfAKind.getInstance();
                                case "escalera color" -> StraightFlush.getInstance();
                                case "escalera real" -> RoyalFlush.getInstance();
                                default -> null;
                            };
                            if (points == 1) {
                                jokers.add(this.creator.createPlayedHandBonus(name, description, new DoNotModify(), new Add(new Score(multiplier)), hand));
                            } else {
                                jokers.add(this.creator.createPlayedHandBonus(name, description, new Add(new Score(points)), new DoNotModify(), hand));
                            }
                        }

                        if (entry.getKey().equals("Bonus por Descarte")) {
                            if (points == 1) {
                                jokers.add(this.creator.createDiscardBonus(name, description, new DoNotModify(), new Multiply(new Score(multiplier))));
                            } else {
                                jokers.add(this.creator.createDiscardBonus(name, description, new Add(new Score(points)), new DoNotModify()));
                            }
                        }

                        if (entry.getKey().equals("Chance de activarse aleatoriamente")) {
                            JsonNode activation = joker.getActivation();
                            int limit = activation.get("1 en").asInt();
                            Probability probability = new Probability(limit);
                            if (points == 1) {
                                jokers.add(this.creator.createRandomActivation(name, description, new DoNotModify(), new Multiply(new Score(multiplier)), probability));
                            } else {
                                jokers.add(this.creator.createRandomActivation(name, description, new Add(new Score(points)), new DoNotModify(), probability));
                            }
                        }
                    }
                });
            }
        } catch (Exception e) {
            throw new CouldNotReadException();
        }
        return jokers;
    }
}

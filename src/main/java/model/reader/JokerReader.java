package model.reader;

import model.creators.JokerCreator;
import model.exceptions.CouldNotReadException;
import model.hands.*;
import model.jokers.Joker;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;

public class JokerReader {

    private final String JSON_JOKER = "/cardsInfo/comodines.json";
    private JokerCreator creator;

    public JokerReader() {
        this.creator = new JokerCreator();
    }

    public ArrayList<Joker> jokerReader() throws FileNotFoundException {

        String src = System.getProperty("user.dir") + JSON_JOKER;
        ArrayList<Joker> jokers = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();

        try (FileReader fileReader = new FileReader(src)) {
            Object obj = jsonParser.parse(fileReader);
            JSONObject jsonObject = (JSONObject) obj;


            for (Object categoryKey : jsonObject.keySet()) {
                JSONObject category = (JSONObject) jsonObject.get(categoryKey);

                String categoryDescription = (String) category.get("descripcion"); //Primera descripcion que explica que hace el comodin, creo que no se utiliza

                JSONArray jokersArray = (JSONArray) category.get("comodines");

                if (categoryKey.equals("Combinación")) {
                    return jokers;
                }

                for (Object key : jokersArray) {

                    JSONObject joker = (JSONObject) key;

                    jokers.add(this.basicJokerReader(joker, categoryKey));

//                    if (categoryKey.equals("Combinación")) { //La parte de Comodines Combinacion no anda todavia. Es todo lo que esta comentado
//
//                        JSONArray combinedJokersArray = (JSONArray) joker.get("comodines");
//
//                        ArrayList<Joker> combinedJokers = new ArrayList<>();
//
//                        String actualCombinedJokerName  = (String) joker.get("nombre");
//
//                        for (Object combinedKey : combinedJokersArray) { // Aca se rompe
//
//                            JSONObject combinedJoker = (JSONObject) combinedKey;
//                            String combinedName = (String) combinedJoker.get("nombre");
//
//                            int iteration = 0;
//                            boolean found = false;
//                            Joker foundJoker = null;
//
//                            while (iteration < jokers.size() || (! found)) {
//
//                                if (jokers.get(iteration).isMyName(combinedName)) {
//                                    foundJoker = jokers.get(iteration);
//                                    found = true;
//                                }
//
//                                iteration++;
//                            }
//
//                            if (foundJoker != null) {
//                                combinedJokers.add(foundJoker);
//                            }
//                        }
//
//                        jokers.add(this.creator.createCombinated(actualCombinedJokerName, combinedJokers));
//
//                    } else {
//                        jokers.add(this.basicJokerReader(joker, categoryKey));
//                    }
                }
            }
        } catch (Exception e) {
            throw new CouldNotReadException();

        }
        return jokers;
    }

    public Joker basicJokerReader(JSONObject joker, Object categoryKey) {

        Joker actualJoker = null;

        String name = (String) joker.get("nombre");
        String description = (String) joker.get("descripcion");

        Object activationObj = joker.get("activacion");
        String activation;

        try {
            activation = new JSONObject((Map<?, ?>) activationObj).toJSONString();
        } catch (ClassCastException e) {
            activation = activationObj.toString();
        }

        JSONObject effect = (JSONObject) joker.get("efecto");
        int points = Math.toIntExact((Long) effect.get("puntos"));
        int multiplicator = Math.toIntExact((Long) effect.get("multiplicador"));

        if (categoryKey.equals("Al Puntaje")) {

            actualJoker = (this.creator.createForTheScore(name, description, activation, points, multiplicator));

        }

        if (categoryKey.equals("Bonus por Mano Jugada")) {

            Hand hand = this.handValidator(activation);

            if (hand != null) {

                actualJoker = (this.creator.createPlayedHandBonus(name, description, activation, points, multiplicator, hand));

            }

        }

        if (categoryKey.equals("Bonus por Descarte")) {

            if (description.contains("fichas")) {

                actualJoker = (this.creator.createForPointsDB(name, description, activation, points, multiplicator));

            } else if (description.contains("multiplicación")) {

                actualJoker = (this.creator.createForMultiplierDB(name, description, activation, points, multiplicator));
            }

        }

        if (categoryKey.equals("Chance de activarse aleatoriamente")) {

            if (description.contains("Mult.")) {

                actualJoker = (this.creator.createForMultiplierRA(name, description, activation, points, multiplicator));

            } else if (description.contains("puntos.")) {

                actualJoker = (this.creator.createForPointsRA(name, description, activation, points, multiplicator));

            }

        }

        return actualJoker;

    }

    public Hand handValidator(String typeHand) {

        if (typeHand.contains("par") ) {
            return new Pair(null);
        }

        if (typeHand.contains("trio")) {
            return new ThreeOfAKind(null);
        }

        if (typeHand.contains("escalera")) {
            return new Straight(null);
        }

        if (typeHand.contains("full")) {
            return new FullHouse(null);
        }

        if (typeHand.contains("color")) {
            return new Flush(null);
        }

        if (typeHand.contains("poker")) {
            return new FourOfAKind(null);
        }

        if (typeHand.contains("escalera de color")) {
            return new StraightFlush(null);
        }

        if (typeHand.contains("escalera real")) {
            return new RoyalFlush(null);
        }

        return null;
    }
}

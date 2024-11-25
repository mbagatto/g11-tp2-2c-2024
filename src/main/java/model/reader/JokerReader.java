package model.reader;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.Map;

public class JokerReader {

    public void read() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, JokerData> jsonData = mapper.readValue(new File(System.getProperty("user.dir") + "/cardsInfo/comodines.json"),
                    mapper.getTypeFactory().constructMapType(Map.class, String.class, JokerData.class));
            for (Map.Entry<String, JokerData> entry : jsonData.entrySet()) {
                entry.getValue().getJokers().forEach(joker -> {

                    if (entry.getKey().equals("Al Puntaje")) {
                        System.out.println("Comodin: " + joker.getName());
                        System.out.println("Puntitos: " + joker.getEffect().getPoints());
                        System.out.println("Multiplier: " + joker.getEffect().getMultiplier());
                    }

                    if (entry.getKey().equals("Bonus por Mano Jugada")) {
                        System.out.println("Comodin: " + joker.getName());
                        System.out.println("Puntitos: " + joker.getEffect().getPoints());
                        System.out.println("Multiplier: " + joker.getEffect().getMultiplier());
                    }

                    if (entry.getKey().equals("Bonus por Descarte")) {
                        System.out.println("Comodin: " + joker.getName());
                        System.out.println("Puntitos: " + joker.getEffect().getPoints());
                        System.out.println("Multiplier: " + joker.getEffect().getMultiplier());
                    }

                    if (entry.getKey().equals("Chance de activarse aleatoriamente")) {
                        System.out.println("Comodin: " + joker.getName());
                        System.out.println("Puntitos: " + joker.getEffect().getPoints());
                        System.out.println("Multiplier: " + joker.getEffect().getMultiplier());
                    }
                    if (entry.getKey().equals("Combinación")) {
                        System.out.println("Comodin: " + joker.getName());
                        System.out.println("Comodin: " + joker.getDescription());
                        for (JokerData internalJoker : joker.getJokers()) {
                            System.out.println("Comodin: " + internalJoker.getName());
                            System.out.println("Puntitos: " + internalJoker.getEffect().getPoints());
                            System.out.println("Multiplier: " + internalJoker.getEffect().getMultiplier());
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
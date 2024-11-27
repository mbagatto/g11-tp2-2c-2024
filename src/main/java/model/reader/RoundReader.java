//package model.reader;
//
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class RoundReader {
//    private List<RoundData> rounds;
//
//    public RoundReader() {
//        this.rounds = new ArrayList<>();
//    }
//
//
//    public ArrayList<RoundData> read(String jsonFilePath) {
//        try {
//            ObjectMapper mapper = new ObjectMapper();
//            JsonNode rootNode = mapper.readTree(new File(jsonFilePath));
//            JsonNode roundsNode = rootNode.get("rondas");
//
//            for (JsonNode rondaNode : roundsNode) {
//                RoundData ronda = new RoundData();
//                ronda.setNumber(rondaNode.get("nro").asInt());
//                ronda.setHands(rondaNode.get("manos").asInt());
//                ronda.setDiscards(rondaNode.get("descartes").asInt());
//                ronda.setScoreToBeat(rondaNode.get("puntajeASuperar").asInt());
//
//                JsonNode tiendaNode = rondaNode.get("tienda");
//                if (tiendaNode != null) {
//                    RoundData.StoreData store = new RoundData.Tienda();
//
//                    JsonNode jokersNode = storeNode.get("comodines");
//                    if (jokersNode != null && jokersNode.isArray()) {
//                        List<RondaData.Comodin> comodines = new ArrayList<>();
//                        for (JsonNode comodinNode : comodinesNode) {
//                            RondaData.Comodin comodin = new RondaData.Comodin();
//                            comodin.setNombre(comodinNode.get("nombre").asText());
//                            comodin.setDescripcion(comodinNode.get("descripcion").asText());
//                            comodin.setActivacion(comodinNode.get("activacion"));
//                            JsonNode efectoNode = comodinNode.get("efecto");
//                            if (efectoNode != null) {
//                                RondaData.Efecto efecto = new RondaData.Efecto();
//                                efecto.setPuntos(efectoNode.get("puntos").asInt());
//                                efecto.setMultiplicador(efectoNode.get("multiplicador").asDouble());
//                                comodin.setEfecto(efecto);
//                            }
//                            comodines.add(comodin);
//                        }
//                        tienda.setComodines(comodines);
//                    }
//
//                    // Leer carta
//                    JsonNode cartaNode = tiendaNode.get("carta");
//                    if (cartaNode != null) {
//                        RondaData.Carta carta = new RondaData.Carta();
//                        carta.setNombre(cartaNode.get("nombre").asText());
//                        carta.setPalo(cartaNode.get("palo").asText());
//                        carta.setNumero(cartaNode.get("numero").asText());
//                        carta.setPuntos(cartaNode.get("puntos").asInt());
//                        carta.setMultiplicador(cartaNode.get("multiplicador").asDouble());
//                        tienda.setCarta(carta);
//                    }
//
//                    // Leer tarots
//                    JsonNode tarotsNode = tiendaNode.get("tarots");
//                    if (tarotsNode != null && tarotsNode.isArray()) {
//                        List<RondaData.Tarot> tarots = new ArrayList<>();
//                        for (JsonNode tarotNode : tarotsNode) {
//                            RondaData.Tarot tarot = new RondaData.Tarot();
//                            tarot.setNombre(tarotNode.get("nombre").asText());
//                            tarot.setDescripcion(tarotNode.get("descripcion").asText());
//                            JsonNode efectoNode = tarotNode.get("efecto");
//                            if (efectoNode != null) {
//                                RondaData.Efecto efecto = new RondaData.Efecto();
//                                efecto.setPuntos(efectoNode.get("puntos").asInt());
//                                efecto.setMultiplicador(efectoNode.get("multiplicador").asDouble());
//                                tarot.setEfecto(efecto);
//                            }
//                            tarots.add(tarot);
//                        }
//                        tienda.setTarots(tarots);
//                    }
//
//                    ronda.setTienda(tienda);
//                }
//
//                rondas.add(ronda);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return rondas;
//    }
//}

package model.reader;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
//import model.Round;
//import model.Store;
import model.Tarot;
import model.round.Round;
import model.round.Store;
import model.cards.Card;
import model.decks.JokerDeck;
import model.decks.TarotDeck;
import model.exceptions.CouldNotReadException;
import model.jokers.Joker;


import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class RoundReader {
    private ArrayList<Round> rounds;

    public RoundReader() {
        this.rounds = new ArrayList<>();
    }

    public ArrayList<Round> read(String pathRound) {


        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            File file = new File(System.getProperty("user.dir") + pathRound);
            BalatroData balatroData = objectMapper.readValue(file, BalatroData.class);
            List<RoundData> roundData = balatroData.getRounds();

            for(RoundData round : roundData) {
                this.rounds.add(this.roundGenerator(round));
            }

        } catch (Exception e) {
            throw new CouldNotReadException();
        }
        return this.rounds;
    }

    public Round roundGenerator(RoundData round) {
        int number = round.getNumber();
        int hands = round.getHands();
        int discards = round.getDiscards();
        int scoreToBeat  = round.getScoreToBeat();
        StoreData storeData = round.getStore();
        Store store = this.storeGenerator(storeData);
        return (new Round(number, hands, discards, scoreToBeat, store));
    }

    public Store storeGenerator(StoreData storeData) {
        List<JokerData> jokers = storeData.getJokers();
        List<TarotData> tarots = storeData.getTarots();
        EnglishCardData cardData = storeData.getEnglishCardData();

        ArrayList<Joker> realJokers = new ArrayList<>();
        JokerDeck jokerDeck = new JokerDeck();
        jokerDeck.fillDeck();
        for (JokerData jokerData : jokers) {
            Joker actualJoker = jokerDeck.findJokerByName(jokerData.getName());
            if (actualJoker != null) {
                realJokers.add(actualJoker);
            }
        }

        ArrayList<Tarot> realTarots = new ArrayList<>();
        TarotDeck tarotDeck = new TarotDeck();
        tarotDeck.fillDeck();
        for (TarotData tarotData : tarots) {
            Tarot actualTarot = tarotDeck.findTarotByName(tarotData.getName());
            if (actualTarot != null) {
                realTarots.add(actualTarot);
            }
        }
        EnglishCardParser englishCardParser = new EnglishCardParser();
        Card card = englishCardParser.cardGenerator(cardData);
        return (new Store(realJokers, realTarots, card));
    }
}

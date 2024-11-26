package model.reader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.exceptions.CouldNotReadException;
import model.tarots.Tarot;
import java.io.File;
import java.util.ArrayList;

public class TarotReader {
    private ArrayList<Tarot> tarots;

    public TarotReader() {
        this.tarots = new ArrayList<>();
    }

    public ArrayList<Tarot> read() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File(System.getProperty("user.dir") + "/cardsInfo/tarots.json"));
            JsonNode tarotsNode = rootNode.get("tarots");

            for (JsonNode tarotNode : tarotsNode) {

                String nombre = tarotNode.get("nombre").asText();
                String descripcion = tarotNode.get("descripcion").asText();
                JsonNode efectoNode = tarotNode.get("efecto");

                int puntos = efectoNode.get("puntos").asInt();
                double multiplicador = efectoNode.get("multiplicador").asDouble();

                String sobre = tarotNode.get("sobre").asText();
                String ejemplar = tarotNode.get("ejemplar").asText();
                Tarot tarotExample = new Tarot(nombre);
                this.tarots.add(tarotExample);
                System.out.println(tarotExample.getName());
                // Aca se deberia elegir que tipo de objeto Tarot se crea
                /*
                Tarot tarot = new Tarot();
                tarot.setNombre(nombre);
                tarot.setDescripcion(descripcion);
                Tarot.Efecto efecto = new Tarot.Efecto();
                efecto.setPuntos(puntos);
                efecto.setMultiplicador(multiplicador);
                tarot.setEfecto(efecto);
                tarot.setSobre(sobre);
                tarot.setEjemplar(ejemplar);
                tarots.add(tarot);
                 */

            }

        } catch (Exception e) {
            throw new CouldNotReadException();
        }
        return this.tarots;
    }
}

package model;

import model.cards.Card;
import model.reader.EnglishCardReader;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReaderTest {
    @Test
    public void testReadFile() throws FileNotFoundException {
        EnglishCardReader reader = new EnglishCardReader();
        ArrayList<Card> cards = reader.englishCardReader();
        assertTrue(true);
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;







public class TarotTest {

    @Test
    public void testChangeCardMultiplierToSix() {
        // Crear instancia de Tarot
        Tarot tarot = new Tarot();
        tarot.setBehaviour(new ForMultiplier());
        int expectedScore = 30;

        Card card = new Card(5, "Hearts");

        // Cambiar el multiplicador de la carta

        card.applyTarot(tarot);

        // Verificar que el valor de la carta se ha cambiado a 6
        assertEquals(expectedScore, card.getScore(), "El valor de la carta debería ser 6 después de aplicar el multiplicador");
    }


    @Test
    public void testChangeHandPointsToTen() {
        // Crear instancia de Tarot
        Tarot tarot = new Tarot();
        tarot.setBehaviour(new ForValue());

        // Crear una carta con un valor inicial
        Card card = new Card(7, "Spades");

        // Cambiar el valor de la carta usando el tarot para asignar 10

        card.applyTarot(tarot);

        // Verificar que el valor de la carta se ha cambiado a 10
        assertEquals(10, card.getScore(), "El valor de la carta debería ser 10 después de aplicar el tarot");
    }

    
    /*
    // Test 1: Verificar que una carta de tarot modifique el multiplicador de una carta a 6

    // y que el puntaje se aplique correctamente
    /*
    @Test
    public void testChangeCardMultiplierToSix() {

        Tarot tarotMock = mock(Tarot.class);
        when(tarotMock.changeMultiplier(anyInt())).thenReturn(6);


        Card card = new Card(5, "Hearts");
        card.applyTarot(tarotMock); // Aplicar el tarot mockeado

        // Verificar que el valor de la carta se ha modificado a 6
        assertEquals(6, card.getValue(), "El valor de la carta debería ser 6 después de aplicar el multiplicador");
    }

     */

    // Test 2: Verificar que una carta de tarot cambie los puntos de una carta a 10
    // y que el puntaje final se aplique correctamente
    /*
    @Test
    public void testChangeCardPointsToTen() {

        Tarot tarotMock = mock(Tarot.class);
        when(tarotMock.changeMultiplier(anyInt())).thenReturn(10);


        Card card = new Card(7, "Spades"); // Inicialmente tiene un valor de 7
        card.applyTarot(tarotMock); // Aplicar el tarot mockeado

        // Verificar que el valor de la carta se ha modificado a 10
        assertEquals(10, card.getValue(), "El valor de la carta debería ser 10 después de aplicar el tarot");
    }


     */
}

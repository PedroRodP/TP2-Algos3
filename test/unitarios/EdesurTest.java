package unitarios;

import modelo.Jugador;
import modelo.casilleros.Edesur;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;
import modelo.excepciones.ExcepcionNoExistePropietario;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nico on 20/11/17.
 */
public class EdesurTest {

    private static final double DELTA = 1e-15;

    @Test
    public void test01UnJugadorCaeEnEdesurYTieneDuenioEntoncesPaga500VecesLoQueIndicanLosDados() throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
        Jugador unJugador = new Jugador();
        Jugador unDuenio = new Jugador();
        Edesur edesur = new Edesur();

        double capitalAnterior = unJugador.getCapital();

        edesur.setPropietario(unDuenio);
        edesur.caer(unJugador, 2);

        Assert.assertEquals(unJugador.getCapital() + 1000, capitalAnterior, DELTA);
    }
}

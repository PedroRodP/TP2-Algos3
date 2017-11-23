package unitarios.casillerosTest;

import modelo.Jugador;
import modelo.casilleros.Tren;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;
import modelo.excepciones.ExcepcionNoExistePropietario;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nico on 22/11/17.
 */
public class TrenTest {

    private static final double DELTA = 1e-15;

    @Test
    public void test01UnJugadorCaeEnTrenesYPagaAlDuenio450VecesLoQueIndicanLosDados() throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
        Jugador unJugador = new Jugador();
        Jugador unDuenio = new Jugador();
        Tren tren = new Tren();

        double capitalAnterior = unJugador.getCapital();

        tren.setPropietario(unDuenio);
        tren.caer(unJugador, 2);

        Assert.assertEquals(unJugador.getCapital() + 900, capitalAnterior, DELTA);
    }
}

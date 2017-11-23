package unitarios.casillerosTest;

import modelo.Jugador;
import modelo.casilleros.Aysa;
import modelo.casilleros.Edesur;
import modelo.casilleros.Subte;
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

    @Test
    public void test02UnJugadorCaeEnTrenYPagaAlDuenio800VecesLoQueIndicanLosDadosPorqueTambienEsDuenioDeSubte() throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
        Jugador unJugador = new Jugador();
        Jugador unDuenio = new Jugador();
        Tren tren = new Tren();
        Subte subte = new Subte();

        double capitalInicial = unJugador.getCapital();

        tren.setPropietario(unDuenio);
        subte.setPropietario(unDuenio);

        tren.setSocio(subte);

        tren.caer(unJugador, 2);

        Assert.assertEquals(unJugador.getCapital() + 1600, capitalInicial, DELTA);
    }
}

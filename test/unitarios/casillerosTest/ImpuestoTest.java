package unitarios.casillerosTest;

import modelo.Jugador;
import modelo.casilleros.Impuesto;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by nico on 20/11/17.
 */
public class ImpuestoTest {

    private static final double DELTA = 1e-15;

    @Test
    public void test01UnJugadorCaeImpuestoAlLujoYSuCapitalSeDecrementaEn10Porciento() throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente {
        Jugador unJugador = new Jugador();
        Impuesto casilleroImpuesto= new Impuesto();

        double capitalAnterior = unJugador.getCapital();

        casilleroImpuesto.caer(unJugador, 1);

        Assert.assertEquals(capitalAnterior * 0.9, unJugador.getCapital(), DELTA);
    }
}

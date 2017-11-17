package unitarios;

import modelo.Jugador;
import modelo.Tablero;
import modelo.casilleros.Carcel;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionPagarFianzaNoCorresponde;
import modelo.excepciones.ExcepcionJugadorYaEstaJugando;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * Created by nico on 12/11/17.
 */
public class CarcelTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void test01JugadorAzulEsArrestadoYRecuperaSuLibertad3RondasDespues() throws ExcepcionJugadorYaEstaJugando {
        
    	Jugador jugadorAzul = new Jugador();
    	ArrayList<Jugador> listaJugadores = new ArrayList<>();
        Tablero unTablero = new Tablero();

        listaJugadores.add(jugadorAzul);
        unTablero.agregarJugadores(listaJugadores);

        Carcel laCarcel = unTablero.getCarcel();

        laCarcel.arrestar(jugadorAzul);

        Assert.assertEquals(1,laCarcel.cantidadDePresos());

        laCarcel.cumplirRonda();
        laCarcel.cumplirRonda();
        laCarcel.cumplirRonda();

        Assert.assertEquals(0,laCarcel.cantidadDePresos());
    }

    @Test
    public void test02JugadorCaeEnCarcelPagaSuFianzaEnTurno2() throws ExcepcionCapitalInsuficiente, ExcepcionPagarFianzaNoCorresponde {
        Jugador jugadorAzul = new Jugador();
        Carcel laCarcel = new Carcel();

        laCarcel.arrestar(jugadorAzul);

        thrown.expect(ExcepcionPagarFianzaNoCorresponde.class);
        jugadorAzul.pagarFianza(laCarcel);
    }
}

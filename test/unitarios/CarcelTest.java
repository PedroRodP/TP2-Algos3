package unitarios;

import modelo.Jugador;
import modelo.Tablero;
import modelo.casilleros.Carcel;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;
import modelo.excepciones.ExcepcionPagarFianzaNoCorresponde;
import modelo.excepciones.ExcepcionJugadorYaEstaJugando;

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
        Carcel carcel = new Carcel();

        carcel.arrestar(jugadorAzul);

        Assert.assertEquals(1, carcel.cantidadDePresos());

        carcel.cumplirRonda();
        carcel.cumplirRonda();
        carcel.cumplirRonda();

        Assert.assertEquals(0, carcel.cantidadDePresos());
    }

    @Test
    public void test02JugadorCaeEnCarcelPagaSuFianzaEnTurno2() throws ExcepcionCapitalInsuficiente, ExcepcionPagarFianzaNoCorresponde, ExcepcionJugadorPreso {
        Jugador jugadorAzul = new Jugador();
        Carcel carcel = new Carcel();
        Tablero unTablero = new Tablero();
        
        jugadorAzul.avanzar(carcel);
        carcel.caer(jugadorAzul, 1);

        thrown.expect(ExcepcionPagarFianzaNoCorresponde.class);
        jugadorAzul.pagarFianza();
    }
}

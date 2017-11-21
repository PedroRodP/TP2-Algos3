package unitarios;

import modelo.Jugador;
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
    public void test02JugadorCaeEnCarcelPagaYNoPuedePagarSuFianzaEnPrimerTurno() throws ExcepcionCapitalInsuficiente, ExcepcionPagarFianzaNoCorresponde, ExcepcionJugadorPreso {
        Jugador jugadorAzul = new Jugador();
        Carcel carcel = new Carcel();
        
        jugadorAzul.avanzar(carcel);
        carcel.caer(jugadorAzul, 1);

        thrown.expect(ExcepcionPagarFianzaNoCorresponde.class);
        jugadorAzul.pagarFianza();
    }

    @Test
    public void test03JugadorCaeEnCarcelYNoPuedePagarSufianzaEnTurno3PorFaltaDeFondos() throws ExcepcionJugadorPreso, ExcepcionPagarFianzaNoCorresponde, ExcepcionCapitalInsuficiente, ExcepcionJugadorYaEstaJugando {
        Jugador jugadorAzul = new Jugador();
        Carcel carcel = new Carcel();

        jugadorAzul.avanzar(carcel);
        carcel.caer(jugadorAzul, 1);
        carcel.cumplirRonda();
        carcel.cumplirRonda();

        jugadorAzul.pagar(60000); //Disminuyo en sesenta mil el capital del jugador, asi, luego, no podrá pagar la fianza.

        thrown.expect(ExcepcionCapitalInsuficiente.class);
        jugadorAzul.pagarFianza();

        thrown.expect(ExcepcionJugadorPreso.class);
        jugadorAzul.avanzar(carcel);
    }

    @Test
    public void test04JugadorCaeEnCarcelYPagaSuFianzaEnTurno2YQuedaEnLibertad() throws ExcepcionJugadorPreso, ExcepcionJugadorYaEstaJugando, ExcepcionPagarFianzaNoCorresponde, ExcepcionCapitalInsuficiente {
        Jugador jugadorAzul = new Jugador();
        Carcel carcel = new Carcel();
        Carcel otraCarcel = new Carcel();

        carcel.caer(jugadorAzul, 1);
        carcel.cumplirRonda();

        jugadorAzul.pagarFianza();
        jugadorAzul.avanzar(otraCarcel);

        Assert.assertNotEquals(carcel,jugadorAzul.getPosicion());
    }

}

package unitarios.casillerosTest;

import modelo.excepciones.ExcepcionNoExistePropietario;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import modelo.Jugador;
import modelo.Tablero;
import modelo.casilleros.SaltaSur;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionTerrenoOcupado;
import modelo.excepciones.ExcepcionJugadorPreso;
import org.junit.rules.ExpectedException;

public class RetrocesoTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void test01unRetrocesoDinamicoMueveAlJugadorQueCaeEnElla() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionJugadorPreso, ExcepcionNoExistePropietario {
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		
		unTablero.agregarJugador(unJugador);

		thrown.expect(ExcepcionNoExistePropietario.class);
		unTablero.avanzar(unJugador, 12);

		thrown.expect(ExcepcionNoExistePropietario.class);
		unTablero.avanzar(unJugador, 6); //Avanza hasta Retroceso Dinamico con valorDados = 6
		
		//Debe retroceder 4 casilleros y caer en Salta Sur
		
		Assert.assertEquals((new SaltaSur()).getClass(), unJugador.getPosicion().getClass());
		
	}
}

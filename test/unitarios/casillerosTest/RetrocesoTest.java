package unitarios.casillerosTest;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import modelo.Jugador;
import modelo.Tablero;
import modelo.casilleros.Retroceso;
import modelo.casilleros.Salida;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionTerrenoOcupado;
import modelo.excepciones.ExcepcionJugadorPreso;

public class RetrocesoTest {
	
	@Test
	public void test01unRetrocesoDinamicoMueveAlJugadorQueCaeEnElla() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionJugadorPreso {
		
		Jugador unJugador = new Jugador();
		ArrayList<Jugador> listaJugadores = new ArrayList<>();
		Tablero unTablero = new Tablero();
		Retroceso unRetroceso = new Retroceso();
			
		listaJugadores.add(unJugador);		
		unTablero.agregarJugadores(listaJugadores);
		unRetroceso.caer(unJugador,unTablero, 4);
		
		Assert.assertNotEquals((new Salida()).getClass(), unJugador.getPosicion().getClass());
		
	}
}

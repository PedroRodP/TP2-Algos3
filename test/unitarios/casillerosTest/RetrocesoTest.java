package unitarios.casillerosTest;

import org.junit.Assert;
import org.junit.Test;

import modelo.Jugador;
import modelo.Tablero;
import modelo.casilleros.Retroceso;
import modelo.casilleros.Salida;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionTerrenoOcupado;
import modelo.excepciones.JugadorEstaPresoException;

public class RetrocesoTest {
	
	@Test
	public void test01unRetrocesoDinamicoMueveAlJugadorQueCaeEnElla() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, JugadorEstaPresoException{
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Retroceso unRetroceso = new Retroceso();
			
		unTablero.setJugador(unJugador);
		unRetroceso.retrocederDinamicamente(unJugador,unTablero, 4);
		
		Assert.assertNotEquals((new Salida()).getClass(), unTablero.getUbicacion(unJugador).getClass());
		
	}
}

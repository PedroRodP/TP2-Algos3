package unitarios.casillerosTest;

import org.junit.Assert;
import org.junit.Test;

import modelo.Jugador;
import modelo.Tablero;
import modelo.casilleros.Aysa;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionTerrenoOcupado;
import modelo.excepciones.ExcepcionJugadorPreso;

public class AvanceTest {
	
	@Test
	public void test01unAvanceDinamicoMueveAlJugadorQueCaeEnElla() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionJugadorPreso {
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
			
		unTablero.agregarJugador(unJugador);
		unTablero.avanzar(unJugador, 7); //Avanza hasta Avance Dinamico con valorDados = 7
		
		//Deberia avanzar 100000 % 7. Es decir, 5 casilleros y caer en Aysa
		
		Assert.assertEquals((new Aysa()).getClass(), unJugador.getPosicion().getClass());
		
	}
	

}

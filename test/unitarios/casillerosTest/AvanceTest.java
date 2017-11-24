package unitarios.casillerosTest;

import modelo.excepciones.ExcepcionNoExistePropietario;
import org.junit.Assert;
import org.junit.Test;

import modelo.Jugador;
import modelo.Tablero;
import modelo.casilleros.Avance;
import modelo.casilleros.Aysa;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionTerrenoOcupado;
import modelo.excepciones.ExcepcionJugadorPreso;

public class AvanceTest {
	
	@Test
	public void test01unAvanceDinamicoMueveAlJugadorQueCaeEnElla() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionJugadorPreso, ExcepcionNoExistePropietario {
		
		Jugador unJugador = new Jugador();
			
		unJugador.setUltimoValorDeDados(7);
		unJugador.avanzar(new Avance());
		
		//Deberia avanzar 100000 % 7. Es decir, 5 casilleros y caer en Aysa
		
		Assert.assertEquals(new Aysa(), unJugador.getPosicion());
		
	}
	

}

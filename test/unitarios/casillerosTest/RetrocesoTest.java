package unitarios.casillerosTest;

import modelo.excepciones.ExcepcionNoExistePropietario;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import modelo.Jugador;
import modelo.Tablero;
import modelo.casilleros.Retroceso;
import modelo.casilleros.SaltaSur;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionTerrenoOcupado;
import modelo.excepciones.ExcepcionJugadorPreso;
import org.junit.rules.ExpectedException;

public class RetrocesoTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void test01unRetrocesoDinamicoMueveAlJugadorQueCaeEnElla() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionJugadorPreso {
		
		Jugador unJugador = new Jugador();
		
		unJugador.setUltimoValorDeDados(6);
		try {
			unJugador.avanzar(new Retroceso());
		} catch (ExcepcionNoExistePropietario e) {
			
		}
			
		//Debe retroceder 4 casilleros y caer en Salta Sur
		
		Assert.assertEquals(unJugador.getPosicion(),new SaltaSur());
		
	}

}

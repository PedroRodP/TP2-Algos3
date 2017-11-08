package unitarios;

import org.junit.Test;

import modelo.Jugador;
import modelo.casilleros.Barrio;
import modelo.casilleros.SantaFe;
import modelo.excepciones.ExcepcionTerrenoOcupado;

import org.junit.Assert;

public class SantaFeTest {
	
	private static final double DELTA = 1e-15;

	@Test
	public void test01ComprarTerrenoNoOcupadoDescuentaPrecioCorrectoDelCapitalDelJugador() {
		
		Jugador jugador = new Jugador();
		Barrio barrio = new SantaFe();
		
		try { 
			barrio.comprarTerreno(jugador);
		}
		catch (ExcepcionTerrenoOcupado e) {}
		
		Assert.assertEquals(15000, 100000 - jugador.balance(), DELTA);
	}
}

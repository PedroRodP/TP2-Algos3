package unitarios.casillerosTest;

import org.junit.Test;

import modelo.Jugador;
import modelo.casilleros.Barrio;
import modelo.casilleros.SantaFe;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionTerrenoOcupado;

import org.junit.Assert;

public class SantaFeTest {
	
	private static final double DELTA = 1e-15;

	@Test
	public void test01ComprarTerrenoNoOcupadoDescuentaPrecioCorrectoDelCapitalDelJugador() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente {
		
		Jugador jugador = new Jugador();
		Barrio barrio = new SantaFe();
		
		barrio.caer(jugador, 1);
		
		Assert.assertEquals(15000, 100000 - jugador.getCapital(), DELTA);
	}
	
	@Test (expected = ExcepcionCapitalInsuficiente.class)
	public void test02ComprarTerrenoSinDineroArrojaExcepcionCapitalInsuficiente() throws ExcepcionCapitalInsuficiente {
		
		Jugador jugador = new Jugador();
		Barrio barrio = new SantaFe();
		
		jugador.pagar(100000); //Su capital queda en 0
		barrio.caer(jugador, 1);
	}
}

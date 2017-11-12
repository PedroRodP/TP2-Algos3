package unitarios.casillerosTest;

import org.junit.Test;

import modelo.Jugador;
import modelo.casilleros.Barrio;
import modelo.casilleros.BsAsNorte;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionTerrenoOcupado;

import org.junit.Assert;

public class BsAsNorteTest {
	
	private static final double DELTA = 1e-15;

	@Test
	public void test01ComprarTerrenoNoOcupadoDescuentaPrecioCorrectoDelCapitalDelJugador() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente {
		
		Jugador jugador = new Jugador();
		Barrio barrio = new BsAsNorte();
		
		barrio.comprarTerreno(jugador);
		
		Assert.assertEquals(25000, 100000 - jugador.balance(), DELTA);
	}
	
	@Test (expected = ExcepcionTerrenoOcupado.class)
	public void test02ComprarTerrenoOcupadoArrojaExcepcion() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente {
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		Barrio barrio = new BsAsNorte();
		
		barrio.comprarTerreno(jugador1);
		barrio.comprarTerreno(jugador2);
		
	}
}

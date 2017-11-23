package unitarios.casillerosTest;

import modelo.casilleros.BsAsSur;
import org.junit.Test;

import modelo.Jugador;
import modelo.casilleros.Barrio;
import modelo.casilleros.BsAsNorte;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionNoExistePropietario;
import modelo.excepciones.ExcepcionTerrenoCompleto;
import modelo.excepciones.ExcepcionTerrenoOcupado;

import org.junit.Assert;

public class BsAsNorteTest {
	
	private static final double DELTA = 1e-15;

	@Test
	public void test01ComprarTerrenoNoOcupadoDescuentaPrecioCorrectoDelCapitalDelJugador() throws ExcepcionCapitalInsuficiente, ExcepcionTerrenoOcupado {
		
		Jugador jugador = new Jugador();
		Barrio barrio = new BsAsNorte();
		
		barrio.serComprado(jugador);
		
		Assert.assertEquals(25000, 100000 - jugador.getCapital(), DELTA);
	}
	
	@Test (expected = ExcepcionCapitalInsuficiente.class)
	public void test02ComprarTerrenoSinDineroArrojaExcepcionCapitalInsuficiente() throws ExcepcionCapitalInsuficiente, ExcepcionTerrenoOcupado {
		
		Jugador jugador = new Jugador();
		Barrio barrio = new BsAsNorte();
		
		jugador.pagar(100000); //Su capital queda en 0
		barrio.serComprado(jugador);
		
	}
	
	@Test
	public void test03ComprarTerrenoNoOcupadoAsignaComoPropietarioAlJugadorComprador() throws ExcepcionCapitalInsuficiente, ExcepcionTerrenoOcupado {
		
		Jugador jugador = new Jugador();
		Barrio barrio = new BsAsNorte();
		
		barrio.serComprado(jugador);
		
		Assert.assertEquals(jugador, barrio.getPropietario());
	}
	
	@Test (expected = ExcepcionTerrenoOcupado.class)
	public void test04ComprarTerrenoOcupadoArrojaExcepcionTerrenoOcupado() throws ExcepcionCapitalInsuficiente, ExcepcionTerrenoOcupado {
		
		Jugador jugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Barrio barrio = new BsAsNorte();
		
		barrio.serComprado(jugador);
		barrio.serComprado(otroJugador);
	}

	@Test
	public void test05UnJugadorEsDuenioDeBsAsNorteYBsAsSurEntoncesConstruyeUnaCasaPor5000Pesos() throws ExcepcionCapitalInsuficiente, ExcepcionTerrenoOcupado, ExcepcionTerrenoCompleto, ExcepcionNoExistePropietario {
		Jugador unJugador = new Jugador();
		BsAsNorte bsAsNorte = new BsAsNorte();
		BsAsSur bsAsSur = new BsAsSur();

		double montoInicial = unJugador.getCapital();

		bsAsNorte.setPropietario(unJugador);
		bsAsSur.setPropietario(unJugador);

		bsAsNorte.construirCasa();

		Assert.assertEquals(montoInicial, unJugador.getCapital() + 5000, DELTA);
	}

	//Test 10 de la 2da entrega
	@Test
	public void test05JugadorPagaAlquilerDeUnaCasaCorrectamente() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionTerrenoCompleto, ExcepcionNoExistePropietario {
		
		Jugador jugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Barrio barrio = new BsAsNorte();
		
		barrio.serComprado(otroJugador);
		barrio.edificar();
		barrio.serAlquilado(jugador);
		
		double alquilerConUnaCasa = 3500;
		
		Assert.assertEquals(100000 - alquilerConUnaCasa, jugador.getCapital(), DELTA);

	}
}

package unitarios.casillerosTest;

import modelo.casilleros.BsAsNorte;
import modelo.casilleros.SaltaSur;
import modelo.excepciones.*;
import org.junit.Assert;
import org.junit.Test;

import modelo.Jugador;
import modelo.casilleros.Barrio;
import modelo.casilleros.SaltaNorte;

public class SaltaNorteTest {

	private static final double DELTA = 1e-15;

	@Test
	public void test01ComprarTerrenoNoOcupadoDescuentaPrecioCorrectoDelCapitalDelJugador() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente {
		
		Jugador jugador = new Jugador();
		Barrio barrio = new SaltaNorte();
		
		barrio.serComprado(jugador);
		
		Assert.assertEquals(23000, 100000 - jugador.getCapital(), DELTA);
	}

	@Test (expected = ExcepcionCapitalInsuficiente.class)
	public void test02ComprarTerrenoSinDineroArrojaExcepcionCapitalInsuficiente() throws ExcepcionCapitalInsuficiente, ExcepcionTerrenoOcupado {
		
		Jugador jugador = new Jugador();
		Barrio barrio = new SaltaNorte();
		
		jugador.pagar(100000); //Su capital queda en 0
		barrio.serComprado(jugador);
	}
	
	@Test
	public void test03ComprarTerrenoNoOcupadoAsignaComoPropietarioAlJugadorComprador() throws ExcepcionCapitalInsuficiente, ExcepcionTerrenoOcupado {
		
		Jugador jugador = new Jugador();
		Barrio barrio = new SaltaNorte();
		
		barrio.serComprado(jugador);
		
		Assert.assertEquals(jugador, barrio.getPropietario());
	}
	
	@Test (expected = ExcepcionTerrenoOcupado.class)
	public void test04ComprarTerrenoOcupadoArrojaExcepcionTerrenoOcupado() throws ExcepcionCapitalInsuficiente, ExcepcionTerrenoOcupado {
		
		Jugador jugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Barrio barrio = new SaltaNorte();
		
		barrio.serComprado(jugador);
		barrio.serComprado(otroJugador);
	}
	
	//Test 10 de la 2da entrega
	@Test
	public void test05JugadorPagaAlquilerDeUnaCasaCorrectamente() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionTerrenoCompleto, ExcepcionNoExistePropietario {

		Jugador jugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Barrio barrio = new SaltaNorte();

		barrio.serComprado(otroJugador);
		barrio.edificar();
		barrio.serAlquilado(jugador);

		double alquilerConUnaCasa = 3250;

		Assert.assertEquals(100000 - alquilerConUnaCasa, jugador.getCapital(), DELTA);
	}

	//Test 4-bis de la 2da Entrega
	@Test
	public void test07UnContrincanteCaeEnSaltaNorteDeJugadorYJugadorRecibePagoDe3250PesosPorTenerUnaCasa() throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario, ExcepcionTerrenoCompleto {
		Jugador unJugador = new Jugador();
		Jugador unContrincante = new Jugador();
		SaltaNorte saltaNorte = new SaltaNorte();
		SaltaSur saltaSur = new SaltaSur();

		double montoInicial = unContrincante.getCapital();

		saltaNorte.setPropietario(unJugador);
		saltaSur.setPropietario(unJugador);

		saltaNorte.edificar();
		saltaSur.edificar();
		saltaSur.edificar();

		saltaNorte.caer(unContrincante);

		Assert.assertEquals(montoInicial, unContrincante.getCapital() + 3250, DELTA);
	}

	//Test 6 de la 2da Entrega
	@Test
	public void test09UnJugadorConstruyeUnHotelEnSaltaSurConUnCostoDe7500Pesos() throws ExcepcionTerrenoCompleto, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario, ExcepcionNoSePuedeConstruirHotelAun {
		Jugador unJugador = new Jugador();
		SaltaNorte saltaNorte = new SaltaNorte();
		SaltaSur saltaSur = new SaltaSur();

		saltaNorte.setPropietario(unJugador);
		saltaSur.setPropietario(unJugador);

		saltaNorte.edificar();
		saltaNorte.edificar();
		saltaSur.edificar();
		saltaSur.edificar();

		double montoAntesDelHotel = unJugador.getCapital();
		saltaSur.edificar();

		Assert.assertEquals(montoAntesDelHotel, unJugador.getCapital() + 7500, DELTA);
	}

	//Test 7 de la 2da Entrega
	@Test
	public void test10UnContrincanteCaeEnElHotelDeJugadorRojoEnSaltaSurYPaga5500DeAlquiler() throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario, ExcepcionTerrenoCompleto {
		Jugador jugadorRojo = new Jugador();
		Jugador unContrincante = new Jugador();
		SaltaNorte saltaNorte = new SaltaNorte();
		SaltaSur saltaSur = new SaltaSur();

		saltaNorte.setPropietario(jugadorRojo);
		saltaSur.setPropietario(jugadorRojo);

		saltaNorte.edificar();
		saltaNorte.edificar();
		saltaSur.edificar();
		saltaSur.edificar();

		saltaSur.edificar();

		double montoInicial = unContrincante.getCapital();

		saltaSur.caer(unContrincante);

		Assert.assertEquals(montoInicial, unContrincante.getCapital() + 5500, DELTA);
	}
}

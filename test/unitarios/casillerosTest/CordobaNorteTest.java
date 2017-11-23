package unitarios.casillerosTest;

import modelo.casilleros.*;
import modelo.excepciones.*;
import org.junit.Test;

import modelo.Jugador;

import org.junit.Assert;

public class CordobaNorteTest {
	
	private static final double DELTA = 1e-15;

	@Test
	public void test01ComprarTerrenoNoOcupadoDescuentaPrecioCorrectoDelCapitalDelJugador() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente {
		
		Jugador jugador = new Jugador();
		Barrio barrio = new CordobaNorte();
		
		barrio.serComprado(jugador);
		
		Assert.assertEquals(20000, 100000 - jugador.getCapital(), DELTA);
	}
	
	@Test (expected = ExcepcionCapitalInsuficiente.class)
	public void test02ComprarTerrenoSinDineroArrojaExcepcionCapitalInsuficiente() throws ExcepcionCapitalInsuficiente, ExcepcionTerrenoOcupado {
		
		Jugador jugador = new Jugador();
		Barrio barrio = new CordobaNorte();
		
		jugador.pagar(100000); //Su capital queda en 0
		barrio.serComprado(jugador);
		
	}
	
	@Test
	public void test03ComprarTerrenoNoOcupadoAsignaComoPropietarioAlJugadorComprador() throws ExcepcionCapitalInsuficiente, ExcepcionTerrenoOcupado {
		
		Jugador jugador = new Jugador();
		Barrio barrio = new CordobaNorte();
		
		barrio.serComprado(jugador);
		
		Assert.assertEquals(jugador, barrio.getPropietario());
	}
	
	@Test (expected = ExcepcionTerrenoOcupado.class)
	public void test04ComprarTerrenoOcupadoArrojaExcepcionTerrenoOcupado() throws ExcepcionCapitalInsuficiente, ExcepcionTerrenoOcupado {
		
		Jugador jugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Barrio barrio = new CordobaNorte();
		
		barrio.serComprado(jugador);
		barrio.serComprado(otroJugador);
	}
	
	//Test 10 de la 2da entrega
	@Test
	public void test05JugadorPagaAlquilerDeUnaCasaCorrectamente() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionTerrenoCompleto, ExcepcionNoExistePropietario {

		Jugador jugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Barrio barrio = new CordobaNorte();

		barrio.serComprado(otroJugador);
		barrio.edificar();
		barrio.serAlquilado(jugador);

		double alquilerConUnaCasa = 1800;

		Assert.assertEquals(100000 - alquilerConUnaCasa, jugador.getCapital(), DELTA);
	}

	//Test 2 de la 2da entrega
	@Test
	public void test05UnJugadorEsDuenioDeCordobaNorteYCordobaSurEntoncesConstruyeUnaCasaPor2000Pesos() throws ExcepcionCapitalInsuficiente, ExcepcionTerrenoOcupado, ExcepcionTerrenoCompleto, ExcepcionNoExistePropietario {
		Jugador unJugador = new Jugador();
		CordobaNorte cordobaNorte = new CordobaNorte();
		CordobaSur cordobaSur = new CordobaSur();

		double montoInicial = unJugador.getCapital();

		cordobaNorte.setPropietario(unJugador);
		cordobaSur.setPropietario(unJugador);

		cordobaSur.edificar();

		Assert.assertEquals(montoInicial, unJugador.getCapital() + 2000, DELTA);
	}

	//Test 4-bis de la 2da Entrega
	@Test
	public void test07UnContrincanteCaeEnCordobaNorteDeJugadorYJugadorRecibePagoDe1800PesosPorTenerUnaCasa() throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario, ExcepcionTerrenoCompleto {
		Jugador unJugador = new Jugador();
		Jugador unContrincante = new Jugador();
		CordobaNorte cordobaNorte = new CordobaNorte();
		CordobaSur cordobaSur = new CordobaSur();

		double montoInicial = unContrincante.getCapital();

		cordobaNorte.setPropietario(unJugador);
		cordobaSur.setPropietario(unJugador);

		cordobaNorte.edificar();
		cordobaSur.edificar();
		cordobaSur.edificar();

		cordobaNorte.caer(unContrincante, 1);

		Assert.assertEquals(montoInicial, unContrincante.getCapital() + 1800, DELTA);
	}

	/*
	//Test 5 de la 2da Entrega
	@Test
	public void test08UnContrincanteCaeEnBsAsNorteDeJugadorYJugadorRecibePagoDe3500PesosPorTenerUnaCasa() throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario, ExcepcionTerrenoCompleto, ExcepcionNoSePuedeConstruirHotelAun {
		Jugador unJugador = new Jugador();
		BsAsNorte bsAsNorte = new BsAsNorte();
		BsAsSur bsAsSur = new BsAsSur();

		bsAsNorte.setPropietario(unJugador);
		bsAsSur.setPropietario(unJugador);

		bsAsNorte.edificar();
		bsAsSur.edificar();
		bsAsSur.edificar();

		double montoAntesDelHotel = unJugador.getCapital();
		bsAsNorte.edificarHotel();

		Assert.assertEquals(montoAntesDelHotel, unJugador.getCapital(), DELTA);
	}
	*/

	//Test 6 de la 2da Entrega
	@Test
	public void test09UnJugadorConstruyeUnHotelEnCordobaSurConUnCostoDe3000Pesos() throws ExcepcionTerrenoCompleto, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario, ExcepcionNoSePuedeConstruirHotelAun {
		Jugador unJugador = new Jugador();
		CordobaNorte cordobaNorte = new CordobaNorte();
		CordobaSur cordobaSur = new CordobaSur();

		cordobaNorte.setPropietario(unJugador);
		cordobaSur.setPropietario(unJugador);

		cordobaNorte.edificar();
		cordobaNorte.edificar();
		cordobaSur.edificar();
		cordobaSur.edificar();

		double montoAntesDelHotel = unJugador.getCapital();
		cordobaSur.edificar();

		Assert.assertEquals(montoAntesDelHotel, unJugador.getCapital() + 3000, DELTA);
	}

	//Test 7 de la 2da Entrega
	@Test
	public void test10UnContrincanteCaeEnElHotelDeJugadorAzulEnCordobaSurYPaga3000DeAlquiler() throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario, ExcepcionTerrenoCompleto {
		Jugador jugadorAzul = new Jugador();
		Jugador unContrincante = new Jugador();
		CordobaNorte cordobaNorte = new CordobaNorte();
		CordobaSur cordobaSur = new CordobaSur();

		cordobaNorte.setPropietario(jugadorAzul);
		cordobaSur.setPropietario(jugadorAzul);

		cordobaNorte.edificar();
		cordobaNorte.edificar();
		cordobaSur.edificar();
		cordobaSur.edificar();

		cordobaSur.edificar();

		double montoInicial = unContrincante.getCapital();

		cordobaSur.caer(unContrincante, 1);

		Assert.assertEquals(montoInicial, unContrincante.getCapital() + 3000, DELTA);
	}
}

package unitarios.casillerosTest;

import modelo.casilleros.BsAsSur;
import modelo.excepciones.*;
import org.junit.Rule;
import org.junit.Test;

import modelo.Jugador;
import modelo.casilleros.Barrio;
import modelo.casilleros.BsAsNorte;

import org.junit.Assert;
import org.junit.rules.ExpectedException;

public class BsAsNorteTest {
	
	private static final double DELTA = 1e-15;

	@Rule
	public ExpectedException thrown = ExpectedException.none();

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

	//Test 2 de la 2da entrega
	@Test
	public void test05UnJugadorEsDuenioDeBsAsNorteYBsAsSurEntoncesConstruyeUnaCasaPor5000Pesos() throws ExcepcionCapitalInsuficiente, ExcepcionTerrenoOcupado, ExcepcionTerrenoCompleto, ExcepcionNoExistePropietario {
		Jugador unJugador = new Jugador();
		BsAsNorte bsAsNorte = new BsAsNorte();
		BsAsSur bsAsSur = new BsAsSur();

		double montoInicial = unJugador.getCapital();

		bsAsNorte.setPropietario(unJugador);
		bsAsSur.setPropietario(unJugador);

		bsAsSur.edificar();

		Assert.assertEquals(montoInicial, unJugador.getCapital() + 5000, DELTA);
	}

	//Test 10 de la 2da entrega
	@Test
	public void test06JugadorPagaAlquilerDeUnaCasaCorrectamente() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionTerrenoCompleto, ExcepcionNoExistePropietario {
		
		Jugador jugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Barrio barrio = new BsAsNorte();
		
		barrio.serComprado(otroJugador);
		barrio.edificar();
		barrio.serAlquilado(jugador);
		
		double alquilerConUnaCasa = 3500;
		
		Assert.assertEquals(100000 - alquilerConUnaCasa, jugador.getCapital(), DELTA);

	}

	//Test 4-bis de la 2da Entrega
	@Test
	public void test07UnContrincanteCaeEnBsAsNorteDeJugadorYJugadorRecibePagoDe3500PesosPorTenerUnaCasa() throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario, ExcepcionTerrenoCompleto {
		Jugador unJugador = new Jugador();
		Jugador unContrincante = new Jugador();
		BsAsNorte bsAsNorte = new BsAsNorte();
		BsAsSur bsAsSur = new BsAsSur();

		double montoInicial = unContrincante.getCapital();

		bsAsNorte.setPropietario(unJugador);
		bsAsSur.setPropietario(unJugador);

		bsAsNorte.edificar();
		bsAsSur.edificar();
		bsAsSur.edificar();

		bsAsNorte.caer(unContrincante, 1);

		Assert.assertEquals(montoInicial, unContrincante.getCapital() + 3500, DELTA);
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
	public void test09UnJugadorConstruyeUnHotelEnBsAsSurConunCostoDe8000Pesos() throws ExcepcionTerrenoCompleto, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario, ExcepcionNoSePuedeConstruirHotelAun {
		Jugador unJugador = new Jugador();
		BsAsNorte bsAsNorte = new BsAsNorte();
		BsAsSur bsAsSur = new BsAsSur();

		bsAsNorte.setPropietario(unJugador);
		bsAsSur.setPropietario(unJugador);

		bsAsNorte.edificar();
		bsAsNorte.edificar();
		bsAsSur.edificar();
		bsAsSur.edificar();

		double montoAntesDelHotel = unJugador.getCapital();
		bsAsSur.edificar();

		Assert.assertEquals(montoAntesDelHotel, unJugador.getCapital() + 8000, DELTA);
	}

	//Test 7 de la 2da Entrega
	@Test
	public void test10UnContrincanteCaeEnElHotelDeJugadorAzulEnBsAsSurYPaga5000DeAlquiler() throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario, ExcepcionTerrenoCompleto {
		Jugador unJugador = new Jugador();
		Jugador unContrincante = new Jugador();
		BsAsNorte bsAsNorte = new BsAsNorte();
		BsAsSur bsAsSur = new BsAsSur();

		bsAsNorte.setPropietario(unJugador);
		bsAsSur.setPropietario(unJugador);

		bsAsNorte.edificar();
		bsAsNorte.edificar();
		bsAsSur.edificar();
		bsAsSur.edificar();

		bsAsSur.edificar();

		double montoInicial = unContrincante.getCapital();

		bsAsSur.caer(unContrincante, 1);

		Assert.assertEquals(montoInicial, unContrincante.getCapital() + 5000, DELTA);
	}

}

package unitarios.casillerosTest;

import modelo.casilleros.BsAsNorte;
import org.junit.Test;

import modelo.Jugador;
import modelo.casilleros.Barrio;
import modelo.casilleros.BsAsSur;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionNoExistePropietario;
import modelo.excepciones.ExcepcionTerrenoCompleto;
import modelo.excepciones.ExcepcionTerrenoOcupado;

import org.junit.Assert;

public class BsAsSurTest {

	private static final double DELTA = 1e-15;

	@Test
	public void test01ComprarTerrenoNoOcupadoDescuentaPrecioCorrectoDelCapitalDelJugador() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente {
		
		Jugador jugador = new Jugador();
		Barrio barrio = new BsAsSur();
		
		barrio.serComprado(jugador);
		
		Assert.assertEquals(20000, 100000 - jugador.getCapital(), DELTA);
	}
	
	@Test (expected = ExcepcionCapitalInsuficiente.class)
	public void test02ComprarTerrenoSinDineroArrojaExcepcionCapitalInsuficiente() throws ExcepcionCapitalInsuficiente, ExcepcionTerrenoOcupado {
		
		Jugador jugador = new Jugador();
		Barrio barrio = new BsAsSur();
		
		jugador.pagar(100000); //Su capital queda en 0
		barrio.serComprado(jugador);
	}
	
	@Test
	public void test03ComprarTerrenoNoOcupadoAsignaComoPropietarioAlJugadorComprador() throws ExcepcionCapitalInsuficiente, ExcepcionTerrenoOcupado {
		
		Jugador jugador = new Jugador();
		Barrio barrio = new BsAsSur();
		
		barrio.serComprado(jugador);
		
		Assert.assertEquals(jugador, barrio.getPropietario());
	}
	
	@Test (expected = ExcepcionTerrenoOcupado.class)
	public void test04ComprarTerrenoOcupadoArrojaExcepcionTerrenoOcupado() throws ExcepcionCapitalInsuficiente, ExcepcionTerrenoOcupado {
		
		Jugador jugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Barrio barrio = new BsAsSur();
		
		barrio.serComprado(jugador);
		barrio.serComprado(otroJugador);
	}
	
	//Test 10 de la 2da entrega
	@Test
	public void test05JugadorPagaAlquilerDeUnaCasaCorrectamente() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionTerrenoCompleto, ExcepcionNoExistePropietario {

		Jugador jugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Barrio barrio = new BsAsSur();

		barrio.serComprado(otroJugador);
		barrio.edificar();
		barrio.serAlquilado(jugador);

		double alquilerConUnaCasa = 3000;

		Assert.assertEquals(100000 - alquilerConUnaCasa, jugador.getCapital(), DELTA);
	}
	//Test 3 de la 2da Entrega
	@Test
	public void test06UnContrincanteCaeEnBsAsSurDeJugadorYJugadorRecibePagoDe3000Pesos() throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario, ExcepcionTerrenoCompleto {
		Jugador unJugador = new Jugador();
		Jugador unContrincante = new Jugador();
		BsAsNorte bsAsNorte = new BsAsNorte();
		BsAsSur bsAsSur = new BsAsSur();

		double montoInicial = unContrincante.getCapital();

		bsAsNorte.setPropietario(unJugador);
		bsAsSur.setPropietario(unJugador);

		bsAsNorte.edificar();
		bsAsSur.edificar();

		bsAsSur.caer(unContrincante);

		Assert.assertEquals(montoInicial, unContrincante.getCapital() + 3000, DELTA);
	}

	//Test 4 de la 2da Entrega
	@Test
	public void test07UnContrincanteCaeEnBsAsSurDeJugadorYJugadorRecibePagoDe3500PesosPorTenerDosCasas() throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario, ExcepcionTerrenoCompleto {
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

		bsAsSur.caer(unContrincante);

		Assert.assertEquals(montoInicial, unContrincante.getCapital() + 3500, DELTA);
	}
}

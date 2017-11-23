package unitarios.casillerosTest;

import modelo.casilleros.SaltaNorte;
import org.junit.Assert;
import org.junit.Test;

import modelo.Jugador;
import modelo.casilleros.Barrio;
import modelo.casilleros.SaltaSur;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionNoExistePropietario;
import modelo.excepciones.ExcepcionTerrenoCompleto;
import modelo.excepciones.ExcepcionTerrenoOcupado;

public class SaltaSurTest {
	
	private static final double DELTA = 1e-15;

	@Test
	public void test01ComprarTerrenoNoOcupadoDescuentaPrecioCorrectoDelCapitalDelJugador() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente {
		
		Jugador jugador = new Jugador();
		Barrio barrio = new SaltaSur();
		
		barrio.serComprado(jugador);
		
		Assert.assertEquals(23000, 100000 - jugador.getCapital(), DELTA);
	}

	@Test (expected = ExcepcionCapitalInsuficiente.class)
	public void test02ComprarTerrenoSinDineroArrojaExcepcionCapitalInsuficiente() throws ExcepcionCapitalInsuficiente, ExcepcionTerrenoOcupado {
		
		Jugador jugador = new Jugador();
		Barrio barrio = new SaltaSur();
		
		jugador.pagar(100000); //Su capital queda en 0
		barrio.serComprado(jugador);
	}
	
	@Test
	public void test03ComprarTerrenoNoOcupadoAsignaComoPropietarioAlJugadorComprador() throws ExcepcionCapitalInsuficiente, ExcepcionTerrenoOcupado {
		
		Jugador jugador = new Jugador();
		Barrio barrio = new SaltaSur();
		
		barrio.serComprado(jugador);
		
		Assert.assertEquals(jugador, barrio.getPropietario());
	}
	
	@Test (expected = ExcepcionTerrenoOcupado.class)
	public void test04ComprarTerrenoOcupadoArrojaExcepcionTerrenoOcupado() throws ExcepcionCapitalInsuficiente, ExcepcionTerrenoOcupado {
		
		Jugador jugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Barrio barrio = new SaltaSur();
		
		barrio.serComprado(jugador);
		barrio.serComprado(otroJugador);
	}
	
	//Test 10 de la 2da entrega
	@Test
	public void test05JugadorPagaAlquilerDeUnaCasaCorrectamente() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionTerrenoCompleto, ExcepcionNoExistePropietario {

		Jugador jugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Barrio barrio = new SaltaSur();

		barrio.serComprado(otroJugador);
		barrio.edificar();
		barrio.serAlquilado(jugador);

		double alquilerConUnaCasa = 3250;

		Assert.assertEquals(100000 - alquilerConUnaCasa, jugador.getCapital(), DELTA);
	}

	//Test 3 de la 2da Entrega
	@Test
	public void test06UnContrincanteCaeEnSaltaSurDeJugadorYJugadorRecibePagoDe3250Pesos() throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario, ExcepcionTerrenoCompleto {
		Jugador unJugador = new Jugador();
		Jugador unContrincante = new Jugador();
		SaltaNorte saltaNorte = new SaltaNorte();
		SaltaSur saltaSur = new SaltaSur();

		double montoInicial = unContrincante.getCapital();

		saltaNorte.setPropietario(unJugador);
		saltaSur.setPropietario(unJugador);

		saltaNorte.edificar();
		saltaSur.edificar();

		saltaSur.caer(unContrincante, 1);

		Assert.assertEquals(montoInicial, unContrincante.getCapital() + 3250, DELTA);
	}

	//Test 4 de la 2da Entrega
	@Test
	public void test07UnContrincanteCaeEnSaltaSurDeJugadorYJugadorRecibePagoDe3850PesosPorTenerDosCasas() throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario, ExcepcionTerrenoCompleto {
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

		saltaSur.caer(unContrincante, 1);

		Assert.assertEquals(montoInicial, unContrincante.getCapital() + 3850, DELTA);
	}
}

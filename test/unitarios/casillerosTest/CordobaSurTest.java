package unitarios.casillerosTest;

import modelo.casilleros.CordobaNorte;
import org.junit.Test;

import modelo.Jugador;
import modelo.casilleros.Barrio;
import modelo.casilleros.CordobaSur;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionNoExistePropietario;
import modelo.excepciones.ExcepcionTerrenoCompleto;
import modelo.excepciones.ExcepcionTerrenoOcupado;

import org.junit.Assert;

public class CordobaSurTest {

	private static final double DELTA = 1e-15;

	@Test
	public void test01ComprarTerrenoNoOcupadoDescuentaPrecioCorrectoDelCapitalDelJugador() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente {
		
		Jugador jugador = new Jugador();
		Barrio barrio = new CordobaSur();
		
		barrio.serComprado(jugador);
		
		Assert.assertEquals(18000, 100000 - jugador.getCapital(), DELTA);
	}
	
	@Test (expected = ExcepcionCapitalInsuficiente.class)
	public void test02ComprarTerrenoSinDineroArrojaExcepcionCapitalInsuficiente() throws ExcepcionCapitalInsuficiente, ExcepcionTerrenoOcupado {
		
		Jugador jugador = new Jugador();
		Barrio barrio = new CordobaSur();
		
		jugador.pagar(100000); //Su capital queda en 0
		barrio.serComprado(jugador);
	}
	
	@Test
	public void test03ComprarTerrenoNoOcupadoAsignaComoPropietarioAlJugadorComprador() throws ExcepcionCapitalInsuficiente, ExcepcionTerrenoOcupado {
		
		Jugador jugador = new Jugador();
		Barrio barrio = new CordobaSur();
		
		barrio.serComprado(jugador);
		
		Assert.assertEquals(jugador, barrio.getPropietario());
	}
	
	@Test (expected = ExcepcionTerrenoOcupado.class)
	public void test04ComprarTerrenoOcupadoArrojaExcepcionTerrenoOcupado() throws ExcepcionCapitalInsuficiente, ExcepcionTerrenoOcupado {
		
		Jugador jugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Barrio barrio = new CordobaSur();
		
		barrio.serComprado(jugador);
		barrio.serComprado(otroJugador);
	}
	
	//Test 10 de la 2da entrega
	@Test
	public void test05JugadorPagaAlquilerDeUnaCasaCorrectamente() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionTerrenoCompleto, ExcepcionNoExistePropietario {

		Jugador jugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Barrio barrio = new CordobaSur();

		barrio.serComprado(otroJugador);
		barrio.edificar();
		barrio.serAlquilado(jugador);

		double alquilerConUnaCasa = 1500;

		Assert.assertEquals(100000 - alquilerConUnaCasa, jugador.getCapital(), DELTA);
	}

	//Test 3 de la 2da Entrega
	@Test
	public void test06UnContrincanteCaeEnCordobaSurDeJugadorYJugadorRecibePagoDe1500Pesos() throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario, ExcepcionTerrenoCompleto {
		Jugador unJugador = new Jugador();
		Jugador unContrincante = new Jugador();
		CordobaNorte cordobaNorte = new CordobaNorte();
		CordobaSur cordobaSur = new CordobaSur();

		double montoInicial = unContrincante.getCapital();

		cordobaNorte.setPropietario(unJugador);
		cordobaSur.setPropietario(unJugador);

		cordobaNorte.edificar();
		cordobaSur.edificar();

		cordobaSur.caer(unContrincante);

		Assert.assertEquals(montoInicial, unContrincante.getCapital() + 1500, DELTA);
	}

	//Test 4 de la 2da Entrega
	@Test
	public void test07UnContrincanteCaeEnCordobaSurDeJugadorYJugadorRecibePagoDe2500PesosPorTenerDosCasas() throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario, ExcepcionTerrenoCompleto {
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

		cordobaSur.caer(unContrincante);

		Assert.assertEquals(montoInicial, unContrincante.getCapital() + 2500, DELTA);
	}
}

package unitarios.casillerosTest;

import org.junit.Assert;
import org.junit.Test;

import modelo.Jugador;
import modelo.casilleros.Barrio;
import modelo.casilleros.Neuquen;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionNoExistePropietario;
import modelo.excepciones.ExcepcionTerrenoCompleto;
import modelo.excepciones.ExcepcionTerrenoOcupado;

public class NeuquenTest {

	private static final double DELTA = 1e-15;

	@Test
	public void test01ComprarTerrenoNoOcupadoDescuentaPrecioCorrectoDelCapitalDelJugador() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente {
		
		Jugador jugador = new Jugador();
		Barrio barrio = new Neuquen();
		
		barrio.serComprado(jugador);
		
		Assert.assertEquals(17000, 100000 - jugador.getCapital(), DELTA);
	}
	
	@Test (expected = ExcepcionCapitalInsuficiente.class)
	public void test02ComprarTerrenoSinDineroArrojaExcepcionCapitalInsuficiente() throws ExcepcionCapitalInsuficiente, ExcepcionTerrenoOcupado {
		
		Jugador jugador = new Jugador();
		Barrio barrio = new Neuquen();
		
		jugador.pagar(100000); //Su capital queda en 0
		barrio.serComprado(jugador);
	}
	
	@Test
	public void test03ComprarTerrenoNoOcupadoAsignaComoPropietarioAlJugadorComprador() throws ExcepcionCapitalInsuficiente, ExcepcionTerrenoOcupado {
		
		Jugador jugador = new Jugador();
		Barrio barrio = new Neuquen();
		
		barrio.serComprado(jugador);
		
		Assert.assertEquals(jugador, barrio.getPropietario());
	}
	
	@Test (expected = ExcepcionTerrenoOcupado.class)
	public void test04ComprarTerrenoOcupadoArrojaExcepcionTerrenoOcupado() throws ExcepcionCapitalInsuficiente, ExcepcionTerrenoOcupado {
		
		Jugador jugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Barrio barrio = new Neuquen();
		
		barrio.serComprado(jugador);
		barrio.serComprado(otroJugador);
	}
	
	//Test 10 de la 2da entrega
		@Test
		public void test05JugadorPagaAlquilerDeUnaCasaCorrectamente() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionTerrenoCompleto, ExcepcionNoExistePropietario {
			
			Jugador jugador = new Jugador();
			Jugador otroJugador = new Jugador();
			Barrio barrio = new Neuquen();
			
			barrio.serComprado(otroJugador);
			barrio.edificar();
			barrio.serAlquilado(jugador);
			
			double alquilerConUnaCasa = 3800;
			
			Assert.assertEquals(100000 - alquilerConUnaCasa, jugador.getCapital(), DELTA);
		}
}

package unitarios;

import modelo.casilleros.Neuquen;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionTerrenoOcupado;
import org.junit.Test;
import org.junit.Assert;

import modelo.Jugador;
import modelo.Tablero;
import modelo.casilleros.Carcel;
import modelo.casilleros.Edesur;
import modelo.casilleros.Salida;

public class JugadorTest {

	@Test
	public void test01ElJugadorEmpiezaSuTurnoDesdeLaSalida(){
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		
		unJugador.setTablero(unTablero);
		unTablero.setJugador(unJugador);
		
		Assert.assertEquals(unJugador.getUbicacion().getClass(),(new Salida()).getClass());
		
	
	}
	
	@Test
	public void test02ElJugadorAvanza3CasillerosYCaeEnEdesur(){
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		
		unJugador.setTablero(unTablero);
		unTablero.setJugador(unJugador);
		unJugador.avanzar(3);
		
		Assert.assertEquals(unJugador.getUbicacion().getClass(),(new Edesur()).getClass());

	}

	@Test
	public void test03JugadorCompraNeuquenYQuedaComoPropietario() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente {
		Jugador unDuenio = new Jugador();
		Neuquen neuquen = new Neuquen();

		neuquen.comprarTerreno(unDuenio);

		Assert.assertEquals(neuquen.getPropietario(), unDuenio);
	}
	
	@Test
	public void test04SiUnJugadorAvanza20CasillerosCaeDeNuevoEnLaSalida(){
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		
		unJugador.setTablero(unTablero);
		unTablero.setJugador(unJugador);
		
		unJugador.avanzar(20);
		
		Assert.assertEquals(unJugador.getUbicacion().getClass(),(new Salida()).getClass());
		
	}
	
	@Test
	public void test05SiUnJugadorAvanza25CasillerosDaLaVueltaYCaeEnCarcel(){
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		
		unJugador.setTablero(unTablero);
		unTablero.setJugador(unJugador);
		
		unJugador.avanzar(25);
		
		Assert.assertEquals((new Carcel()).getClass(), unJugador.getUbicacion().getClass());
		
	}
}

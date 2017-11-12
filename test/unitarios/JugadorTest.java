package unitarios;

import modelo.casilleros.Carcel;
import modelo.casilleros.Neuquen;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionTerrenoOcupado;
import modelo.excepciones.JugadorEstaPresoException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;

import modelo.Jugador;
import modelo.Tablero;
import modelo.casilleros.Carcel;
import modelo.casilleros.Edesur;
import modelo.casilleros.Salida;
import org.junit.rules.ExpectedException;

public class JugadorTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void test01ElJugadorEmpiezaSuTurnoDesdeLaSalida(){
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		
		unTablero.setJugador(unJugador);
		
		Assert.assertEquals(unTablero.getUbicacion(unJugador).getClass(),(new Salida()).getClass());

	}
	
	@Test
	public void test02ElJugadorAvanza3CasillerosYCaeEnEdesur() throws JugadorEstaPresoException {
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		
		unTablero.setJugador(unJugador);
		unTablero.avanzar(unJugador, 3);
		
		Assert.assertEquals(unTablero.getUbicacion(unJugador).getClass(),(new Edesur()).getClass());

	}

	@Test
	public void test03JugadorCompraNeuquenYQuedaComoPropietario() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente {
		Jugador unDuenio = new Jugador();
		Neuquen neuquen = new Neuquen();

		neuquen.comprarTerreno(unDuenio);

		Assert.assertEquals(neuquen.getPropietario(), unDuenio);
	}

	@Test
	public void test04JugadorCaeEnLaCarcelYNoPuedeDesplazarse() throws JugadorEstaPresoException {
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Carcel miCarcel = new Carcel();

		unTablero.setJugador(unJugador);
		miCarcel.arrestar(unJugador);

		thrown.expect(JugadorEstaPresoException.class);
		unTablero.avanzar(unJugador, 1);
	}

	@Test
	public void test05SiUnJugadorAvanza20CasillerosCaeDeNuevoEnLaSalida() throws JugadorEstaPresoException {
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		
		unTablero.setJugador(unJugador);
		unTablero.avanzar(unJugador, 20);
		
		Assert.assertEquals(unTablero.getUbicacion(unJugador).getClass(),(new Salida()).getClass());
	}
	
	@Test
	public void test06SiUnJugadorAvanza25CasillerosDaLaVueltaYCaeEnCarcel() throws JugadorEstaPresoException {
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		
		unTablero.setJugador(unJugador);
		
		unTablero.avanzar(unJugador, 25);
		
		Assert.assertEquals((new Carcel()).getClass(), unTablero.getUbicacion(unJugador).getClass());
		
	}
}

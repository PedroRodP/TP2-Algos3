package unitarios;

import modelo.casilleros.Carcel;
import modelo.casilleros.Neuquen;
import modelo.excepciones.ExcepcionTerrenoOcupado;
import modelo.excepciones.JugadorEstaPresoException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.Assert;

import modelo.Jugador;
import modelo.Tablero;
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
		
		unJugador.setTablero(unTablero);
		
		Assert.assertEquals(unJugador.getUbicacion().getClass(),(new Salida()).getClass());

	}
	
	@Test
	public void test02ElJugadorAvanza3CasillerosYCaeEnEdesur(){
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		
		unJugador.setTablero(unTablero);
		unJugador.avanzar(3);
		
		Assert.assertEquals(unJugador.getUbicacion().getClass(),(new Edesur()).getClass());

	}

	@Test
	public void test03JugadorCompraNeuquenYQuedaComoPropietario() throws ExcepcionTerrenoOcupado {
		Jugador unDuenio = new Jugador();
		Neuquen neuquen = new Neuquen();

		neuquen.comprarTerreno(unDuenio);

		Assert.assertEquals(neuquen.getPropietario(), unDuenio);
	}

	@Test
	public void test01JugadorCaeEnLaCarcelYNoPuedeDesplazarse(){
		Jugador unJugador = new Jugador();
		Carcel miCarcel = new Carcel();

		miCarcel.arrestar(unJugador);

		thrown.expect(JugadorEstaPresoException.class);
		unJugador.avanzar(1);
	}
}

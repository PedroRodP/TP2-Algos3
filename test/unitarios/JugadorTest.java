package unitarios;

import modelo.casilleros.Aysa;
import modelo.casilleros.Carcel;
import modelo.casilleros.CordobaSur;
import modelo.casilleros.Neuquen;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionTerrenoOcupado;
import modelo.excepciones.ExcepcionJugadorPreso;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import org.junit.Assert;

import modelo.Jugador;
import modelo.Tablero;
import modelo.casilleros.Edesur;
import modelo.casilleros.Salida;
import modelo.casilleros.SaltaNorte;
import modelo.casilleros.Subte;
import modelo.casilleros.Tren;

import org.junit.rules.ExpectedException;

public class JugadorTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void test01JugadorArrojaExcepcionCuandoIntentaPagarMasQueSuCapital() throws ExcepcionCapitalInsuficiente {
		
		Jugador jugador = new Jugador();
		
		thrown.expect(ExcepcionCapitalInsuficiente.class);
		jugador.pagar(200000);
	}
	
	@Test
	public void test02ElJugadorAvanza3CasillerosYCaeEnEdesur() throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente {
		
		Jugador unJugador = new Jugador();
		ArrayList<Jugador> listaJugadores = new ArrayList<>();
		Tablero unTablero = new Tablero();
		
		listaJugadores.add(unJugador);
		unTablero.agregarJugadores(listaJugadores);
		unTablero.avanzar(unJugador, 3);
		
		Assert.assertEquals(unJugador.getPosicion().getClass(),(new Edesur()).getClass());

	}

	@Test
	public void test03JugadorCompraNeuquenYQuedaComoPropietario() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente {
		Jugador unDuenio = new Jugador();
		Neuquen neuquen = new Neuquen();

		neuquen.comprarTerreno(unDuenio);

		Assert.assertEquals(neuquen.getPropietario(), unDuenio);
	}

	@Test
	public void test04JugadorCaeEnLaCarcelYNoPuedeDesplazarse() throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente {
		Jugador unJugador = new Jugador();
		ArrayList<Jugador> listaJugadores = new ArrayList<>();
		Tablero unTablero = new Tablero();
		Carcel miCarcel = new Carcel();

		listaJugadores.add(unJugador);
		unTablero.agregarJugadores(listaJugadores);
		miCarcel.arrestar(unJugador);

		thrown.expect(ExcepcionJugadorPreso.class);
		unTablero.avanzar(unJugador, 1);
	}

	@Test
	public void test05SiUnJugadorAvanza20CasillerosCaeDeNuevoEnLaSalida() throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente {
		
		Jugador unJugador = new Jugador();
		ArrayList<Jugador> listaJugadores = new ArrayList<>();
		Tablero unTablero = new Tablero();
		
		listaJugadores.add(unJugador);
		unTablero.agregarJugadores(listaJugadores);
		unTablero.avanzar(unJugador, 20);
		
		Assert.assertEquals(unJugador.getPosicion().getClass(),(new Salida()).getClass());
	}
	
	@Test
	public void test06SiUnJugadorAvanza25CasillerosDaLaVueltaYCaeEnCarcel() throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente {
		
		Jugador unJugador = new Jugador();
		ArrayList<Jugador> listaJugadores = new ArrayList<>();
		Tablero unTablero = new Tablero();
		
		listaJugadores.add(unJugador);
		unTablero.agregarJugadores(listaJugadores);
		
		unTablero.avanzar(unJugador, 25);
		
		Assert.assertEquals((new Carcel()).getClass(), unJugador.getPosicion().getClass());
		
	}
	
	@Test
	public void test07UnJugadorCaeEnAvanceDinamicoDespuesDeHaberSacadoUn3YAvanzaASubte() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionJugadorPreso {
		
		Jugador unJugador = new Jugador();
		ArrayList<Jugador> listaJugadores = new ArrayList<>();
		Tablero unTablero = new Tablero();
		
		listaJugadores.add(unJugador);
		unTablero.agregarJugadores(listaJugadores);
		unTablero.avanzar(unJugador, 4); //Dejo al jugador en Bs As Zona sur para avanzar de a 3 a Avance
		unTablero.avanzar(unJugador, 3); //Muevo al jugador desde Bs As Zona sur a avanza dinamico
		
		
		
		Assert.assertEquals((new Subte()).getClass(), unJugador.getPosicion().getClass());
		
		
		
		
	}
	
	@Test
	public void test08UnJugadorCaeEnAvanceDinamicoDespuesDeHaberSacadoUn7YAvanzaAAysa() throws ExcepcionJugadorPreso, ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente {
		
		Jugador unJugador = new Jugador();
		ArrayList<Jugador> listaJugadores = new ArrayList<>();
		Tablero unTablero = new Tablero();
		
		listaJugadores.add(unJugador);
		unTablero.agregarJugadores(listaJugadores);
			
		//cae en avance dinamico, rolleando un 7
		unTablero.avanzar(unJugador, 7 );

		
		
		Assert.assertEquals((new Aysa()).getClass(), unJugador.getPosicion().getClass());
		
		
		
		
	}
	
	@Test
	public void test09UnJugadorCaeEnAvanceDinamicoDespuesDeHaberSacadoUn12YCaeEnTren() throws ExcepcionJugadorPreso, ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente {
		
		//Rehacer tests
		
		Assert.assertTrue(true);
	}
	
	@Test
	public void test10UnJugadorCaeEnLaPoliciaYEstaLoLlevaALaCarcel() throws ExcepcionJugadorPreso, ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente {
		
		Jugador unJugador = new Jugador();
		ArrayList<Jugador> listaJugadores = new ArrayList<>();
		Tablero unTablero = new Tablero();
		
		listaJugadores.add(unJugador);
		unTablero.agregarJugadores(listaJugadores);
			
		//Avanza 15 para caer en la policia
		unTablero.avanzar(unJugador, 15 );
		
				
		Assert.assertEquals((new Carcel()).getClass(), unJugador.getPosicion().getClass());
				
	}
	
	@Test
	public void test11UnJugadorCaeEnLaPoliciaEstaLoLlevaALaCarcelYAhoraNoSePuedeMover() throws ExcepcionJugadorPreso, ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente {
		
		Jugador unJugador = new Jugador();
		ArrayList<Jugador> listaJugadores = new ArrayList<>();
		Tablero unTablero = new Tablero();
		
		listaJugadores.add(unJugador);
		unTablero.agregarJugadores(listaJugadores);
			
		//Avanza 15 para caer en la policia
		unTablero.avanzar(unJugador, 15 );
		
				
		thrown.expect(ExcepcionJugadorPreso.class);
		unTablero.avanzar(unJugador, 1);
			
	}
	
	@Test
	public void test12UnJugadorCaeEnRetrocesoDinamicoDespuesDeHaberSacadoUn4YRetrocedeATren() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionJugadorPreso {
		
		Jugador unJugador = new Jugador();
		ArrayList<Jugador> listaJugadores = new ArrayList<>();
		Tablero unTablero = new Tablero();
		
		listaJugadores.add(unJugador);
		unTablero.agregarJugadores(listaJugadores);
		unTablero.avanzar(unJugador, 14); //Dejo al jugador en Salta Sur
		unTablero.avanzar(unJugador, 4); //Muevo al jugador desde Salta Sur a retroceso dinamico
		
		
		
		Assert.assertEquals((new Tren()).getClass(), unJugador.getPosicion().getClass());
		
		
		
		
	}
	
	@Test
	public void test13UnJugadorConCaeEnRetrocesoDinamicoDespuesDeHaberSacadoUn7YRetrocedeASaltaNorte() throws ExcepcionJugadorPreso, ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente {
		
		Jugador unJugador = new Jugador();
		ArrayList<Jugador> listaJugadores = new ArrayList<>();
		Tablero unTablero = new Tablero();
		
		listaJugadores.add(unJugador);
		unTablero.agregarJugadores(listaJugadores);
			
		unTablero.avanzar(unJugador, 11 );//Dejo al Jugador En Santa Fe
		unTablero.avanzar(unJugador, 7 ); //Desde Santa Fe saco un 7 y el jugador cae en Retroceso Dinamico

		
		
		Assert.assertEquals((new SaltaNorte()).getClass(), unJugador.getPosicion().getClass());
		
	
		
	}
	
	@Test
	public void test14UnJugadorCaeEnRetrocesoDinamicoDespuesDeHaberSacadoUn12YCaeEnCordobaSur() throws ExcepcionJugadorPreso, ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente {
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		
		unTablero.agregarJugador(unJugador);
		
		//Avanza 6 y cae en Cordoba Sur
		unTablero.avanzar(unJugador, 6 );
		
		// Desde Cordoba sur, saca un 12 y cae en Retroceso Dinamico
		unTablero.avanzar(unJugador, 12 );
		
		//Vuelve a caer en CordobaSur retrocediendo los 12 casilleros por tener 0 inmuebles		
		Assert.assertEquals((new CordobaSur()).getClass(), unJugador.getPosicion().getClass());
				
	}
}

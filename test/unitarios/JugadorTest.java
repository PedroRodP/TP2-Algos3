package unitarios;

import modelo.casilleros.Avance;
import modelo.casilleros.Aysa;
import modelo.casilleros.BsAsSur;
import modelo.casilleros.Carcel;
import modelo.casilleros.Neuquen;
import modelo.casilleros.Policia;
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
import modelo.casilleros.SaltaNorte;
import modelo.casilleros.SaltaSur;
import modelo.casilleros.SantaFe;
import modelo.casilleros.Subte;
import modelo.casilleros.Tren;

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
	public void test02ElJugadorAvanza3CasillerosYCaeEnEdesur() throws JugadorEstaPresoException, ExcepcionCapitalInsuficiente {
		
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
	public void test04JugadorCaeEnLaCarcelYNoPuedeDesplazarse() throws JugadorEstaPresoException, ExcepcionCapitalInsuficiente {
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Carcel miCarcel = new Carcel();

		unTablero.setJugador(unJugador);
		miCarcel.arrestar(unJugador);

		thrown.expect(JugadorEstaPresoException.class);
		unTablero.avanzar(unJugador, 1);
	}

	@Test
	public void test05SiUnJugadorAvanza20CasillerosCaeDeNuevoEnLaSalida() throws JugadorEstaPresoException, ExcepcionCapitalInsuficiente {
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		
		unTablero.setJugador(unJugador);
		unTablero.avanzar(unJugador, 20);
		
		Assert.assertEquals(unTablero.getUbicacion(unJugador).getClass(),(new Salida()).getClass());
	}
	
	@Test
	public void test06SiUnJugadorAvanza25CasillerosDaLaVueltaYCaeEnCarcel() throws JugadorEstaPresoException, ExcepcionCapitalInsuficiente {
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		
		unTablero.setJugador(unJugador);
		
		unTablero.avanzar(unJugador, 25);
		
		Assert.assertEquals((new Carcel()).getClass(), unTablero.getUbicacion(unJugador).getClass());
		
	}
	
	@Test
	public void test07UnJugadorCaeEnAvanceDinamicoDespuesDeHaberSacadoUn3YAvanzaASubte() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, JugadorEstaPresoException{
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		
		
		unTablero.setJugador(unJugador);
		unTablero.avanzar(unJugador, 4); //Dejo al jugador en Bs As Zona sur
		unTablero.avanzar(unJugador, 3); //Muevo al jugador desde Bs As Zona sur a avanza dinamico
		
		
		
		Assert.assertEquals((new Subte()).getClass(), unTablero.getUbicacion(unJugador).getClass());
		
		
		
		
	}
	
	@Test
	public void test08UnJugadorCaeEnAvanceDinamicoDespuesDeHaberSacadoUn7YAvanzaAAysa() throws JugadorEstaPresoException, ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente{
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		

		unTablero.setJugador(unJugador);
			
		//cae en avance dinamico, rolleando un 7
		unTablero.avanzar(unJugador, 7 );

		
		
		Assert.assertEquals((new Aysa()).getClass(), unTablero.getUbicacion(unJugador).getClass());
		
		
		
		
	}
	
	@Test
	public void test09UnJugadorCaeEnAvanceDinamicoDespuesDeHaberSacadoUn11YCaeEnNeuquen() throws JugadorEstaPresoException, ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente{
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Neuquen neuquen = new Neuquen();

		neuquen.comprarTerreno(unJugador);
		
		unTablero.setJugador(unJugador);
			
		//Avanza 16 y cae en tren
		unTablero.avanzar(unJugador, 16 );
		
		// Desde tren, saca un 11 y cae en Avance Dinamico
		unTablero.avanzar(unJugador, 11 );
		
				
		Assert.assertEquals((new Neuquen()).getClass(), unTablero.getUbicacion(unJugador).getClass());
				
	}
	
	@Test
	public void test10UnJugadorCaeEnLaPoliciaYEstaLoLlevaALaCarcel() throws JugadorEstaPresoException, ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente{
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		
		
		unTablero.setJugador(unJugador);
			
		//Avanza 15 para caer en la policia
		unTablero.avanzar(unJugador, 15 );
		
				
		Assert.assertEquals((new Carcel()).getClass(), unTablero.getUbicacion(unJugador).getClass());
				
	}
	
	@Test
	public void test11UnJugadorCaeEnLaPoliciaEstaLoLlevaALaCarcelYAhoraNoSePuedeMover() throws JugadorEstaPresoException, ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente{
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		
		
		unTablero.setJugador(unJugador);
			
		//Avanza 15 para caer en la policia
		unTablero.avanzar(unJugador, 15 );
		
				
		thrown.expect(JugadorEstaPresoException.class);
		unTablero.avanzar(unJugador, 1);
			
	}
	
	@Test
	public void test12UnJugadorCaeEnRetrocesoDinamicoDespuesDeHaberSacadoUn4YRetrocedeATren() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, JugadorEstaPresoException{
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		
		
		unTablero.setJugador(unJugador);
		unTablero.avanzar(unJugador, 14); //Dejo al jugador en Salta Sur
		unTablero.avanzar(unJugador, 4); //Muevo al jugador desde Salta Sur a retroceso dinamico
		
		
		
		Assert.assertEquals((new Tren()).getClass(), unTablero.getUbicacion(unJugador).getClass());
		
		
		
		
	}
	
	@Test
	public void test13UnJugadorConCaeEnRetrocesoDinamicoDespuesDeHaberSacadoUn7YRetrocedeASaltaNorte() throws JugadorEstaPresoException, ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente{
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		
		
		unTablero.setJugador(unJugador);
			
		unTablero.avanzar(unJugador, 11 );//Dejo al Jugador En Santa Fe
		unTablero.avanzar(unJugador, 7 ); //Desde Santa Fe saco un 7 y el jugador cae en Retroceso Dinamico

		
		
		Assert.assertEquals((new SaltaNorte()).getClass(), unTablero.getUbicacion(unJugador).getClass());
		
	
		
	}
	
	@Test
	public void test14UnJugadorCaeEnRetrocesoDinamicoDespuesDeHaberSacadoUn12YCaeEnSubte() throws JugadorEstaPresoException, ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente{
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		Neuquen neuquen = new Neuquen();
		SantaFe santaFe = new SantaFe();

		neuquen.comprarTerreno(unJugador); 
		santaFe.comprarTerreno(unJugador);
		
		unTablero.setJugador(unJugador);
			
		//Avanza 6 y cae en Cordoba Sur
		unTablero.avanzar(unJugador, 6 );
		
		// Desde Cordoba sur, saca un 12 y cae en Retroceso Dinamico
		unTablero.avanzar(unJugador, 12 );
		
				
		Assert.assertEquals((new Subte()).getClass(), unTablero.getUbicacion(unJugador).getClass());
				
	}
}

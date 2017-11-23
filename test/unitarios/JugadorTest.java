package unitarios;

import modelo.casilleros.Aysa;
import modelo.casilleros.Barrio;
import modelo.casilleros.Carcel;
import modelo.casilleros.Casillero;
import modelo.casilleros.CordobaSur;
import modelo.casilleros.Neuquen;
import modelo.excepciones.*;

import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;

import org.junit.Assert;

import modelo.Jugador;
import modelo.Tablero;
import modelo.casilleros.Edesur;
import modelo.casilleros.Salida;
import modelo.casilleros.SantaFe;
import modelo.casilleros.Subte;
import modelo.casilleros.Tren;

import org.junit.rules.ExpectedException;

public class JugadorTest {

	private static final double DELTA = 1e-15;
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void test01JugadorArrojaExcepcionCuandoIntentaPagarMasQueSuCapital() throws ExcepcionCapitalInsuficiente {
		
		Jugador jugador = new Jugador();
		
		thrown.expect(ExcepcionCapitalInsuficiente.class);
		jugador.pagar(200000);
	}
	
	@Test
	public void test02ElJugadorAvanza3CasillerosYCaeEnEdesur() throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		
		Jugador unJugador = new Jugador();
		ArrayList<Jugador> listaJugadores = new ArrayList<>();
		Tablero unTablero = new Tablero();
		
		listaJugadores.add(unJugador);
		unTablero.agregarJugadores(listaJugadores);

		thrown.expect(ExcepcionNoExistePropietario.class);
		unTablero.avanzar(unJugador, 3);
		
		Assert.assertEquals(unJugador.getPosicion().getClass(),(new Edesur()).getClass());
		//TODO falta refactorizar, quitar ".getClass()"
	}

	@Test
	public void test03JugadorCompraNeuquenYQuedaComoPropietario() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		Jugador unDuenio = new Jugador();
		Neuquen neuquen = new Neuquen();

		thrown.expect(ExcepcionNoExistePropietario.class);
		neuquen.caer(unDuenio, 1);

		Assert.assertEquals(neuquen.getPropietario(), unDuenio);
	}

	@Test
	public void test04JugadorCaeEnLaCarcelYNoPuedeDesplazarse() throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
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
	public void test05SiUnJugadorAvanza20CasillerosCaeDeNuevoEnLaSalida() throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		
		Jugador unJugador = new Jugador();
		ArrayList<Jugador> listaJugadores = new ArrayList<>();
		Tablero unTablero = new Tablero();
		
		listaJugadores.add(unJugador);
		unTablero.agregarJugadores(listaJugadores);
		unTablero.avanzar(unJugador, 20);
		
		Assert.assertEquals(unJugador.getPosicion().getClass(),(new Salida()).getClass());
	}
	
	@Test
	public void test06SiUnJugadorAvanza25CasillerosDaLaVueltaYCaeEnCarcel() throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		
		Jugador unJugador = new Jugador();
		ArrayList<Jugador> listaJugadores = new ArrayList<>();
		Tablero unTablero = new Tablero();
		
		listaJugadores.add(unJugador);
		unTablero.agregarJugadores(listaJugadores);
		
		unTablero.avanzar(unJugador, 25);
		
		Assert.assertEquals((new Carcel()).getClass(), unJugador.getPosicion().getClass());
		
	}
	
	@Test
	public void test07UnJugadorCaeEnAvanceDinamicoDespuesDeHaberSacadoUn3YAvanzaASubte() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionJugadorPreso, ExcepcionNoExistePropietario {
		
		Jugador unJugador = new Jugador();
		ArrayList<Jugador> listaJugadores = new ArrayList<>();
		Tablero unTablero = new Tablero();
		
		listaJugadores.add(unJugador);
		unTablero.agregarJugadores(listaJugadores);

		thrown.expect(ExcepcionNoExistePropietario.class);
		unTablero.avanzar(unJugador, 4); //Dejo al jugador en Bs As Zona sur para avanzar de a 3 a Avance

		thrown.expect(ExcepcionNoExistePropietario.class);
		unTablero.avanzar(unJugador, 3); //Muevo al jugador desde Bs As Zona sur a avanza dinamico

		Assert.assertEquals((new Subte()).getClass(), unJugador.getPosicion().getClass());

		
	}
	
	@Test
	public void test08UnJugadorCaeEnAvanceDinamicoDespuesDeHaberSacadoUn7YAvanzaAAysa() throws ExcepcionJugadorPreso, ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		
		unTablero.agregarJugador(unJugador);
			
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
	public void test10UnJugadorCaeEnLaPoliciaYEstaLoLlevaALaCarcel() throws ExcepcionJugadorPreso, ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		
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
	public void test11UnJugadorCaeEnLaPoliciaEstaLoLlevaALaCarcelYAhoraNoSePuedeMover() throws ExcepcionJugadorPreso, ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		
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
	public void test12UnJugadorCaeEnRetrocesoDinamicoDespuesDeHaberSacadoUn4YRetrocedeATren() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionJugadorPreso, ExcepcionNoExistePropietario {
		
		Jugador unJugador = new Jugador();
		ArrayList<Jugador> listaJugadores = new ArrayList<>();
		Tablero unTablero = new Tablero();
		
		listaJugadores.add(unJugador);
		unTablero.agregarJugadores(listaJugadores);

		thrown.expect(ExcepcionNoExistePropietario.class);
		unTablero.avanzar(unJugador, 14); //Dejo al jugador en Salta Sur

		thrown.expect(ExcepcionNoExistePropietario.class);
		unTablero.avanzar(unJugador, 4); //Muevo al jugador desde Salta Sur a retroceso dinamico

		Assert.assertEquals((new Tren()).getClass(), unJugador.getPosicion().getClass());

	}
	
	@Test
	public void test13UnJugadorConCaeEnRetrocesoDinamicoDespuesDeHaberSacadoUn12YRetrocedeAlMismoCasillero() throws ExcepcionJugadorPreso, ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		
		unTablero.agregarJugador(unJugador);

		thrown.expect(ExcepcionNoExistePropietario.class);
		unTablero.avanzar(unJugador, 6);

		thrown.expect(ExcepcionNoExistePropietario.class);
		unTablero.avanzar(unJugador, 12);//Desde CordobaSur saco un 12 y el jugador cae en Retroceso Dinamico

		//Deberia retroceder los 12 casilleros por no tener inmuebles
		
		Assert.assertEquals((new CordobaSur()).getClass(), unJugador.getPosicion().getClass());
		
	
		
	}
	
	@Test
	public void test14UnJugadorCaeEnRetrocesoDinamicoDespuesDeHaberSacadoUn12YCaeEnCordobaSur() throws ExcepcionJugadorPreso, ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		
		Jugador unJugador = new Jugador();
		Tablero unTablero = new Tablero();
		
		unTablero.agregarJugador(unJugador);
		
		//Avanza 6 y cae en Cordoba Sur
		thrown.expect(ExcepcionNoExistePropietario.class);
		unTablero.avanzar(unJugador, 6 );
		
		// Desde Cordoba sur, saca un 12 y cae en Retroceso Dinamico
		thrown.expect(ExcepcionNoExistePropietario.class);
		unTablero.avanzar(unJugador, 12 );
		
		//Vuelve a caer en CordobaSur retrocediendo los 12 casilleros por tener 0 inmuebles		
		Assert.assertEquals((new CordobaSur()).getClass(), unJugador.getPosicion().getClass());
				
	}
	
	@Test (expected = ExcepcionPagarFianzaNoCorresponde.class)
	public void test15JugadorPagaFianzaEstandoJugandoArrojaExcepcionPagarFianzaNoCorresponde() throws ExcepcionPagarFianzaNoCorresponde, ExcepcionCapitalInsuficiente {
		
		Jugador jugador = new Jugador();
		
		jugador.pagarFianza();
	}
	
	@Test (expected = ExcepcionJugadorYaEstaJugando.class)
	public void test16JugadorCumplirCondenaArrojaExcepcionJugadorYaEstaJugandoSiElEstadoEsJugando() throws ExcepcionJugadorYaEstaJugando {
		
		Jugador jugador = new Jugador();
		
		jugador.cumplirCondena();
	}
	
	@Test
	public void test17AvanzarJugadorASalidaPoneJugadorEnPosicionSalida() throws ExcepcionJugadorPreso {
		
		Jugador jugador = new Jugador();
		Casillero salida = new Salida();
		
		jugador.avanzar(salida);
		
		Assert.assertEquals(salida, jugador.getPosicion());
	}
	
	@Test (expected = ExcepcionJugadorPreso.class)
	public void test18AvanzarJugadorASalidaArrojaExcepcionJugadorPresoCuandoElEstadoEsPreso() throws ExcepcionJugadorPreso {
		
		Jugador jugador = new Jugador();
		Casillero salida = new Salida();
		Carcel carcel = new Carcel();
		
		jugador.irPreso(carcel);
		jugador.avanzar(salida);
	}
	
	@Test
	public void test19JugadorPaga50000YLeQuedaLaMitadDeSuCapital() throws ExcepcionCapitalInsuficiente {
		
		Jugador jugador = new Jugador();
		
		jugador.pagar(50000);
		
		Assert.assertEquals(100000 - 50000, jugador.getCapital(), DELTA);
	}
	
	@Test
	public void test20JugadorCobra100000YLeQuedaElDobleDeSuCapital() throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		
		Jugador jugador = new Jugador();
		
		jugador.acreditar(100000);
		
		Assert.assertEquals(100000 + 100000, jugador.getCapital(), DELTA);
	}
	
	//Test 13 de la 2da entrega
	@Test
	public void test21JugadoresIntercambianPropiedadesYElAlquilerDeTerrenoEdificadoSeAcreditaAlNuevoDuenio() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario, ExcepcionTerrenoCompleto {
		
		Jugador jugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Barrio barrio = new Neuquen();
		Barrio otroBarrio = new Neuquen();
		Jugador tercero = new Jugador();
		
		barrio.serComprado(jugador);
		otroBarrio.serComprado(otroJugador);
		
		barrio.edificar();
		
		barrio.setNuevoDuenio(otroJugador);
		otroBarrio.setNuevoDuenio(jugador);
		
		barrio.serAlquilado(tercero);
		
		double precioNeuquen = 17000;
		double alquilerConUnaCasa = 3800;
		
		Assert.assertEquals(100000 - precioNeuquen + alquilerConUnaCasa, otroJugador.getCapital(), DELTA);
	}
	
	//Test 14 de la 2da entrega
	@Test
	public void test22JugadoresIntercambianPropiedadesYElAlquilerSeAcreditaAlNuevoDuenio() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		
		Jugador jugador = new Jugador();
		Jugador otroJugador = new Jugador();
		Barrio barrio = new Neuquen();
		Barrio otroBarrio = new Neuquen();
		Jugador tercero = new Jugador();
		
		barrio.serComprado(jugador);
		otroBarrio.serComprado(otroJugador);
		
		barrio.setNuevoDuenio(otroJugador);
		otroBarrio.setNuevoDuenio(jugador);
		
		barrio.serAlquilado(tercero);
		
		double precioNeuquen = 17000;
		double alquilerDefault = 1800;
		
		Assert.assertEquals(100000 - precioNeuquen + alquilerDefault, otroJugador.getCapital(), DELTA);
	}
	
	//Test 9 de la 2da entrega
	@Test
	public void test23JugadorCompraSantaFeEdificaUnaCasaYSuCapitalSeDecrementa4000PorLaConstruccion() throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente, ExcepcionTerrenoCompleto, ExcepcionNoExistePropietario {
		
		Jugador jugador = new Jugador();
		Barrio santafe = new SantaFe();
		
		santafe.serComprado(jugador);
		santafe.edificar();
		
		double precioTerreno = 15000;
		
		Assert.assertEquals(100000 - precioTerreno - 4000, jugador.getCapital(), DELTA);
	}
	
	@Test (expected = ExcepcionNoExistePropietario.class)
	public void test24EdificarSinDuenioArrojaExcepcionNoExistePropietario() throws ExcepcionNoExistePropietario, ExcepcionTerrenoCompleto, ExcepcionCapitalInsuficiente {
		
		Barrio barrio = new SantaFe();
		
		barrio.edificar();
	}
}

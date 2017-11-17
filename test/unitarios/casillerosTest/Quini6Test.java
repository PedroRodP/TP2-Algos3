package unitarios.casillerosTest;

import org.junit.Test;

import org.junit.Assert;
import modelo.Jugador;
import modelo.casilleros.Quini6;

public class Quini6Test {
	
	private static final double DELTA = 1e-15;
	
	@Test
	public void test01JugadorCaeEnQuini6PorPrimeraVezYSuCapitalSeIncrementa50000() {
		
		Quini6 quini = new Quini6();
		Jugador jugador = new Jugador();
		
		quini.premiar(jugador);
		
		Assert.assertEquals(50000, jugador.getCapital() - 100000, DELTA);
	}
	
	@Test
	public void test02JugadorCaeEnQuini6PorSegundaVezYSuCapitalSeIncrementa30000() {
		
		Quini6 quini = new Quini6();
		Jugador jugador = new Jugador();
		
		quini.premiar(jugador);
		quini.premiar(jugador);
		
		Assert.assertEquals(30000, jugador.getCapital() - 150000, DELTA);
	}
	
	@Test
	public void test03JugadorCaeEnQuini6PorTerceraVezYSuCapitalYaNoSeIncrementa() {
		
		Quini6 quini = new Quini6();
		Jugador jugador = new Jugador();
		
		quini.premiar(jugador);
		quini.premiar(jugador);
		quini.premiar(jugador);
		
		Assert.assertEquals(0, jugador.getCapital() - 180000, DELTA);
	}

}

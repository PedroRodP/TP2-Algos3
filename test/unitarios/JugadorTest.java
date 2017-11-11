package unitarios;

import org.junit.Test;
import org.junit.Assert;

import modelo.Jugador;
import modelo.Tablero;
import modelo.casilleros.Edesur;
import modelo.casilleros.Salida;

public class JugadorTest {

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
	
}

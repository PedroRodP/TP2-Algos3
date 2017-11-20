package unitarios;

import org.junit.Test;

import modelo.GrupoJugadores;
import modelo.Jugador;
import modelo.Turnador;

import org.junit.Assert;

public class TurnadorTest {

	@Test
	public void test01TurnadorDevuelveDistintosJugadoresPorCadaTurno() {
		
		GrupoJugadores grupo = new GrupoJugadores();
		Turnador turnador = new Turnador(grupo.getJugadores());
		
		Jugador primerJugador = turnador.siguienteTurno();
		Jugador segundoJugador = turnador.siguienteTurno();
		
		Assert.assertNotEquals(primerJugador, segundoJugador);
	}
}

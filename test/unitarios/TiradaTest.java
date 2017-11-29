package unitarios;

import modelo.Jugador;
import modelo.excepciones.ExceptionArrojoDoblesTresVeces;
import org.junit.Test;

import modelo.Tirada;

import org.junit.Assert;

public class TiradaTest {

	@Test
	public void test01ArrojarLosDadosDevuelveUnNumeroEntre1Y12() throws ExceptionArrojoDoblesTresVeces {
		
		Tirada tirada = new Tirada();
		
		int resultado = tirada.arrojarDados();
		
		Assert.assertTrue(1 <= resultado && resultado <= 12);
	}

	//Un jugador arroja los dados y ambos tienen el mismo valor. Verificar que puede volver a jugar.
	@Test
	public void test02JugadorArrojaLosDadosConMismoValorUnaVezYPuedeVuelveAJugar() throws ExceptionArrojoDoblesTresVeces {
		Tirada tiradaJugador = new Tirada();
		int saleDobleEsCero;

		do {
			saleDobleEsCero = tiradaJugador.arrojarDados();
		} while (saleDobleEsCero > 0); //Saca 0 cuando es doble

		Assert.assertEquals(true, tiradaJugador.arrojarDados() >= 0);
	}
}

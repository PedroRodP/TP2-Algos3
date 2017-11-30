package unitarios;

import modelo.Jugador;
import modelo.excepciones.ExcepcionJugadorPreso;
import modelo.excepciones.ExcepcionArrojoDoblesTresVeces;
import org.junit.Test;

import modelo.Tirada;

import org.junit.Assert;

public class TiradaTest {

	@Test
	public void test01ArrojarLosDadosDevuelveUnNumeroEntre0Y12() throws ExcepcionArrojoDoblesTresVeces {
		
		Tirada tirada = new Tirada();
		
		int resultado = tirada.arrojarDados();

		//0 es cuando los dados son dobles
		Assert.assertTrue(0 <= resultado && resultado <= 12);
	}

	//Test 1: 3ra. Entega
	//Un jugador arroja los dados y ambos tienen el mismo valor. Verificar que puede volver a jugar.
	@Test
	public void test02JugadorArrojaLosDadosConMismoValorUnaVezYPuedeVuelveAJugar() throws ExcepcionArrojoDoblesTresVeces {
		Tirada tiradaJugador = new Tirada();
		int saleDobleEsCero;

		do {
			saleDobleEsCero = tiradaJugador.arrojarDados();
		} while (saleDobleEsCero > 0); //Saca 0 cuando es doble

		Assert.assertEquals(true, tiradaJugador.arrojarDados() >= 0);
	}

    //Test 1: 3ra. Entega
    //Un jugador arroja los dados y ambos tienen el mismo valor en dos oportunidades. Verificar que puede volver a jugar.
    @Test
    public void test03JugadorArrojaLosDadosConMismoValorUnaVezYPuedeVuelveAJugar() throws ExcepcionArrojoDoblesTresVeces {
        Tirada tiradaJugador = new Tirada();
        int saleDobleEsCero;

        //Saca doble 1ra vez
        do {
            saleDobleEsCero = tiradaJugador.arrojarDados();
        } while (saleDobleEsCero > 0);

        //Saca doble 2da vez
        do {
            saleDobleEsCero = tiradaJugador.arrojarDados();
        } while (saleDobleEsCero > 0);

        Assert.assertEquals(true, tiradaJugador.arrojarDados() >= 0);
    }

    //Test 1: 3ra. Entega
    //Un jugador arroja los dados. Verificar que este paso de su posición actual a la posición indicada por los dados.
    @Test
    public void test04JugadorArrojaLosDadosYVerificarQueAvanzoDesdeSuPosicionActualHastaLoIndicadoPorLosDados() throws ExcepcionArrojoDoblesTresVeces, ExcepcionJugadorPreso {
	    Jugador unJugador = new Jugador();
	    Tirada tiradaJugador = new Tirada();

	    int posicionActual= unJugador.getPosicionNumerica();
        int cantidadPosiciones = tiradaJugador.arrojarDados();

        unJugador.avanzar(cantidadPosiciones);

	    Assert.assertEquals(posicionActual, unJugador.getPosicionNumerica() - cantidadPosiciones);
    }
}

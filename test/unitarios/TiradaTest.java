package unitarios;

import org.junit.Test;

import modelo.Tirada;

import org.junit.Assert;

public class TiradaTest {

	@Test
	public void test01ArrojarLosDadosDevuelveUnNumeroEntre1Y12() {
		
		Tirada tirada = new Tirada();
		
		int resultado = tirada.arrojarDados();
		
		Assert.assertTrue(1 <= resultado && resultado <= 12);
	}
}

package unitarios;

import org.junit.Test;

import modelo.Dado;

import org.junit.Assert;

public class DadoTest {
	
	@Test
	public void test01ArrojarDadoDevuelveNumeroEntre1y6() {
		
		Dado dado = new Dado();
		
		int resultado = dado.tirar();
		
		Assert.assertTrue(1 <= resultado && resultado <= 6);
	}
}

package modelo;

import modelo.excepciones.ExcepcionArrojoDoblesTresVeces;

public class Tirada {

	private Dado dado1 = new Dado();
	private Dado dado2 = new Dado();
	private int vecesDobles = 0;
	
	public int arrojarDados() throws ExcepcionArrojoDoblesTresVeces {
		if (salieron3Dobles())
			throw new ExcepcionArrojoDoblesTresVeces();

		int numero1 = dado1.tirar();
		int numero2 = dado2.tirar();
		
		int total = numero1 + numero2;

		if (this.registrarDobles(numero1, numero2)) {
			total = 0;
		}

		return total;
	}
	
	private boolean registrarDobles(int numero1, int numero2) {

		if (numero1 == numero2) {
			vecesDobles++;
		} else {
			vecesDobles = 0;
		}

		return (vecesDobles > 0);
	}
	
	public boolean salieron3Dobles() {
		return (vecesDobles > 3);
	}
	
	public boolean salenDobles() {
		return (vecesDobles > 0);
	}
}

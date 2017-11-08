package modelo;

public class Tirada {

	private Dado dado1 = new Dado();
	private Dado dado2 = new Dado();
	
	public int arrojarDados() {
		return (dado1.tirar() + dado2.tirar());
	}
}

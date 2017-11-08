package modelo;

public class Jugador {

	private double capital;
	
	public Jugador() {
		capital = 100000;
	}
	
	public void cobrar(double monto) {
		capital -= monto;
	}
	
	public void acreditar(double monto) {
		capital += monto;
	}
	
	public double balance() {
		return capital;
	}
}

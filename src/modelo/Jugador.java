package modelo;

public class Jugador {

	private double dinero;
	
	public Jugador() {
		dinero = 100000;
	}
	
	public void cobrar(double monto) {
		dinero -= monto;
	}
	
	public void acreditar(double monto) {
		dinero += monto;
	}
	
}

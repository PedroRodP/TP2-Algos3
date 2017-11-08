package modelo.casilleros.estados;

import modelo.Jugador;

public class RegistroDeInmuebles {

	public void cobrar(Jugador jugador) {
		double monto = this.calcularAlquiler();
		jugador.cobrar(monto);
	}
	
	public void edificar() {
		
	}
	
	public double calcularAlquiler() {
		return 0;
	}
	
	public double getValorEdificios() {
		return 0;
	}
	
}
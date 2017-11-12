package modelo.casilleros.estados;

import modelo.Jugador;
import modelo.excepciones.ExcepcionCapitalInsuficiente;

public class RegistroDeInmuebles {

	public void cobrar(Jugador jugador) throws ExcepcionCapitalInsuficiente {
		double monto = this.calcularAlquiler();
		jugador.pagar(monto);
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

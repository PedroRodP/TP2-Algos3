package modelo.casilleros.estados;

import modelo.Jugador;
import modelo.excepciones.ExcepcionCapitalInsuficiente;

public class RegistroDeInmuebles {

	public double calcularAlquiler(Jugador jugador) throws ExcepcionCapitalInsuficiente {
		
		double monto = 0;
		return monto;
	}
	
	public void edificar() {
		
	}
	
	public double calcularReembolso(double precioTerreno) {
		
		double adicional = this.getValorEdificios();
		double total = precioTerreno + adicional;
		
		return (total * 85 / 100);
	}
	
	private double getValorEdificios() {
		return 0;
	}
	
}

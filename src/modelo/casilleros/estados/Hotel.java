package modelo.casilleros.estados;

import modelo.casilleros.Barrio;
import modelo.excepciones.ExcepcionTerrenoCompleto;

public class Hotel implements Construccion {

	private double alquiler;
	
	public Hotel(double alquiler) {
		this.alquiler = alquiler;
	}
	
	@Override
	public Construccion construirEn(Barrio barrio) throws ExcepcionTerrenoCompleto {
		throw new ExcepcionTerrenoCompleto();
	}
	
	@Override
	public double getValorDeAlquiler() {
		return alquiler;
	}
}

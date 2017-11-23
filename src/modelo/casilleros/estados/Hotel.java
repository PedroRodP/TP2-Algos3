package modelo.casilleros.estados;

import modelo.casilleros.Barrio;
import modelo.excepciones.ExcepcionTerrenoCompleto;

public class Hotel implements Construccion {

	private double alquiler;
	private double valorDeConstruccion;
	
	public Hotel(double alquiler, double construccion) {
		this.alquiler = alquiler;
		this.valorDeConstruccion = construccion;
	}
	
	@Override
	public Construccion construirEn(Barrio barrio) throws ExcepcionTerrenoCompleto {
		throw new ExcepcionTerrenoCompleto();
	}
	
	@Override
	public double getValorDeAlquiler() {
		return alquiler;
	}
	
	@Override
	public double getValorDeConstruccion() {
		return valorDeConstruccion;
	}
}

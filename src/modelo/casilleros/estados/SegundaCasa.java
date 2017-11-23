package modelo.casilleros.estados;

import modelo.casilleros.Barrio;

public class SegundaCasa implements Construccion {

	private double alquiler;
	
	public SegundaCasa(double alquiler) {
		this.alquiler = alquiler;
	}
	
	@Override
	public Construccion construirEn(Barrio barrio) {
		return new Hotel(barrio.getPrecioHotel());
	}
	
	@Override
	public double getValorDeAlquiler() {
		return alquiler;
	}
	
}

package modelo.casilleros.estados;

import modelo.casilleros.Barrio;

public class SegundaCasa implements Construccion {

	private double alquiler;
	private double valorDeConstruccion;
	
	public SegundaCasa(double alquiler, double construccion) {
		this.alquiler = alquiler;
		this.valorDeConstruccion = construccion;
	}
	
	@Override
	public Construccion construirEn(Barrio barrio) {
		return new Hotel(barrio.getPrecioHotel(), barrio.getPrecioConstruccionHotel());
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

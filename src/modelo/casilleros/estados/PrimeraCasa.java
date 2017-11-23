package modelo.casilleros.estados;

import modelo.casilleros.Barrio;

public class PrimeraCasa implements Construccion {

	private double alquiler;
	private double valorDeConstruccion;
	
	public PrimeraCasa(double alquiler, double construccion) {
		this.alquiler = alquiler;
		this.valorDeConstruccion = construccion;
	}
	
	@Override
	public Construccion construirEn(Barrio barrio) {
		return new SegundaCasa(barrio.getPrecioSegundaCasa(), barrio.getPrecioConstruccionCasa());
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

package modelo.casilleros.estados;

import modelo.casilleros.Barrio;

public class PrimeraCasa implements Construccion {

	private double alquiler;
	
	public PrimeraCasa(double alquiler) {
		this.alquiler = alquiler;
	}
	
	@Override
	public Construccion construirEn(Barrio barrio) {
		return new SegundaCasa(barrio.getPrecioSegundaCasa());
	}
	
	@Override
	public double getValorDeAlquiler() {
		return alquiler;
	}
	
}

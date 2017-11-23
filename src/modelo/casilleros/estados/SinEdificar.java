package modelo.casilleros.estados;

import modelo.casilleros.Barrio;

public class SinEdificar implements Construccion {

	private double alquiler;
	
	public SinEdificar(double alquiler) {
		this.alquiler = alquiler;
	}
	
	@Override
	public Construccion construirEn(Barrio barrio) {
		return new PrimeraCasa(barrio.getPrecioPrimeraCasa(), barrio.getPrecioConstruccionCasa());
	}
	
	@Override
	public double getValorDeAlquiler() {
		return alquiler;
	}
	
	@Override
	public double getValorDeConstruccion() {
		return 0;
	}
}

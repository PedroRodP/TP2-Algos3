package modelo.casilleros.estados;

import modelo.casilleros.Barrio;
import modelo.excepciones.ExcepcionTerrenoCompleto;

public interface Construccion {

	public Construccion construirEn(Barrio barrio) throws ExcepcionTerrenoCompleto;
	
	public double getValorDeAlquiler();

	public double getValorDeConstruccion();

}

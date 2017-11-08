package modelo.casilleros;

import modelo.Jugador;
import modelo.excepciones.ExcepcionTerrenoOcupado;

public interface Barrio {

	public void comprarTerreno(Jugador jugador) throws ExcepcionTerrenoOcupado;
	
	public double precio();
}

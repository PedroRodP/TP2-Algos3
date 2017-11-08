package modelo.casilleros.estados;

import modelo.Jugador;
import modelo.excepciones.ExcepcionTerrenoOcupado;

public interface Estado {

	public void comprar(Jugador jugador, double precioTerreno) throws ExcepcionTerrenoOcupado;	
}

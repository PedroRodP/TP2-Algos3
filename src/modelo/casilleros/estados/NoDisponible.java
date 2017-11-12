package modelo.casilleros.estados;

import modelo.Jugador;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionTerrenoOcupado;

public class NoDisponible implements Estado {

	@Override
	public void comprar(Jugador jugador, double precioTerreno) throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente {
		
		throw new ExcepcionTerrenoOcupado();
	}

	
}

package modelo.casilleros.estados;

import modelo.Jugador;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionNoExistePropietario;
import modelo.excepciones.ExcepcionTerrenoOcupado;

public class NoDisponible implements Estado {

	@Override
	public void comprarTerreno(Jugador jugador, double precioTerreno) throws ExcepcionTerrenoOcupado {
	
		throw new ExcepcionTerrenoOcupado();
	}	
	
	@Override
	public void venderTerreno(Jugador jugador, double precioTerreno) throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		
		jugador.acreditar(precioTerreno * 0.85);
	}
}

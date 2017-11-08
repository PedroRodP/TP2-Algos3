package modelo.casilleros.estados;

import modelo.Jugador;
import modelo.excepciones.ExcepcionTerrenoOcupado;

public class Disponible implements Estado {

	@Override
	public void comprar(Jugador jugador, double precioTerreno) throws ExcepcionTerrenoOcupado {
		
		jugador.cobrar(precioTerreno);
	}

}

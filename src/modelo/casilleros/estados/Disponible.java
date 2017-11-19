package modelo.casilleros.estados;

import modelo.Jugador;
import modelo.excepciones.ExcepcionCapitalInsuficiente;

public class Disponible implements Estado {

	@Override
	public void comprarTerreno(Jugador jugador, double precioTerreno) throws ExcepcionCapitalInsuficiente {
		
		jugador.pagar(precioTerreno);
	}

}

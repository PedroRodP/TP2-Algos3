package modelo.casilleros.estados;

import modelo.Jugador;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionNoExistePropietario;

public class Disponible implements Estado {

	@Override
	public void comprarTerreno(Jugador jugador, double precioTerreno) throws ExcepcionCapitalInsuficiente {
		
		jugador.pagar(precioTerreno);
	}

	@Override
	public void venderTerreno(Jugador jugador, double precioTerreno) throws ExcepcionNoExistePropietario {
		
		throw new ExcepcionNoExistePropietario();
	}
}

package modelo.casilleros;

import modelo.casilleros.estados.Propietario;

public class Neuquen extends Barrio {

	public Neuquen(){
		
		precioTerreno = 17000;
		
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
}

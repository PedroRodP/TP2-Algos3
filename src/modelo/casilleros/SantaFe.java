package modelo.casilleros;

import modelo.casilleros.estados.Propietario;

public class SantaFe extends Barrio {

	public SantaFe(){
		
		precioTerreno = 15000;
		
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
}

package modelo.casilleros;

import modelo.casilleros.estados.Propietario;

public class Neuquen extends Barrio {

	public Neuquen(){
		
		precioTerreno = 17000;
		alquilerDefault = 1800;
		precioPrimeraCasa = 3800;
		precioSegundaCasa = 3800;
		precioHotel = 3800;
		
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
}

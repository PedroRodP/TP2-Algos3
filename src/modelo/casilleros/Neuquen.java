package modelo.casilleros;

import modelo.casilleros.estados.Propietario;
import modelo.casilleros.estados.RegistroDeInmuebles;

public class Neuquen extends Barrio {

	public Neuquen(){
		
		precioTerreno = 17000;
		alquilerDefault = 1800;
		precioPrimeraCasa = 3800;
		precioSegundaCasa = 3800;
		precioHotel = 3800;
		precioConstruccionCasa = 4800;
		precioConstruccionHotel = 0;
		registro = new RegistroDeInmuebles(alquilerDefault);
		
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
}

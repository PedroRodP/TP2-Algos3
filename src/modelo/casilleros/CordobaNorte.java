package modelo.casilleros;

import modelo.casilleros.estados.Propietario;
import modelo.casilleros.estados.RegistroDeInmuebles;

public class CordobaNorte extends Barrio {

	public CordobaNorte(){
		
		precioTerreno = 20000;
		alquilerDefault = 1300;
		precioPrimeraCasa = 1800;
		precioSegundaCasa = 2900;
		precioHotel = 3500;
		precioConstruccionCasa = 2200;
		precioConstruccionHotel = 3500;
		registro = new RegistroDeInmuebles(alquilerDefault);
		
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
}

package modelo.casilleros;

import modelo.casilleros.estados.Propietario;
import modelo.casilleros.estados.RegistroDeInmuebles;

public class BsAsSur extends Barrio {


	public BsAsSur(){
		
		precioTerreno = 20000;
		alquilerDefault = 2000;
		precioPrimeraCasa = 3000;
		precioSegundaCasa = 3500;
		precioHotel = 5000;
		precioConstruccionCasa = 5000;
		precioConstruccionHotel = 8000;
		registro = new RegistroDeInmuebles(alquilerDefault);
		
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
}
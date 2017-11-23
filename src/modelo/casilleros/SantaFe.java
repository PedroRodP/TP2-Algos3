package modelo.casilleros;

import modelo.casilleros.estados.Propietario;

public class SantaFe extends Barrio {

	public SantaFe(){
		
		precioTerreno = 15000;
		alquilerDefault = 1500;
		precioPrimeraCasa = 3500;
		precioSegundaCasa = 3500;
		precioHotel = 3500;
		
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
}

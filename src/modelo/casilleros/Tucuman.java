package modelo.casilleros;

import modelo.casilleros.estados.Propietario;
import modelo.casilleros.estados.RegistroDeInmuebles;

public class Tucuman extends Barrio {

	public Tucuman(){
		
		precioTerreno = 25000;
		alquilerDefault = 2500;
		precioPrimeraCasa = 4500;
		precioSegundaCasa = 4500;
		precioHotel = 4500;
		precioConstruccionCasa = 7000;
		precioConstruccionHotel = 0;
		registro = new RegistroDeInmuebles(alquilerDefault);
		
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
	
	@Override
	public boolean equals(Object o){
		return (this.getClass()==o.getClass());
	}
}

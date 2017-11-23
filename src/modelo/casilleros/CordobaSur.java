package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.estados.Propietario;
import modelo.casilleros.estados.RegistroDeInmuebles;

public class CordobaSur extends Barrio {

	public CordobaSur(){
		
		precioTerreno = 18000;
		alquilerDefault = 1000;
		precioPrimeraCasa = 1500;
		precioSegundaCasa = 2500;
		precioHotel = 3000;
		precioConstruccionCasa = 2000;
		precioConstruccionHotel = 3000;
		registro = new RegistroDeInmuebles(alquilerDefault);
		
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}

    public void setPropietario(Jugador propietario) {
        administrador.setDuenio(propietario);
    }
}

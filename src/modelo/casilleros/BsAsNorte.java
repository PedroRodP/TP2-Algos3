package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.estados.Propietario;
import modelo.casilleros.estados.SinPropietario;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.casilleros.estados.RegistroDeInmuebles;
import modelo.excepciones.ExcepcionNoExistePropietario;

public class BsAsNorte extends Barrio {

	//private Propietario miDuenio;
	private BsAsSur miSur;

	public BsAsNorte(){
		//this.miDuenio = new SinPropietario();
		precioTerreno = 25000;
		alquilerDefault = 2500;
		precioPrimeraCasa = 3500;
		precioSegundaCasa = 4000;
		precioHotel = 6000;
		precioConstruccionCasa = 5500;
		precioConstruccionHotel = 9000;
		registro = new RegistroDeInmuebles(alquilerDefault);
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return (this.administrador.getDuenio() == unPropietario);
	}

    public void setPropietario(Jugador propietario) {
        //this.miDuenio = propietario;
		administrador.setDuenio(propietario);
    }

}

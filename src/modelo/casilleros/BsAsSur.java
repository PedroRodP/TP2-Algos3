package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.estados.Propietario;
import modelo.casilleros.estados.SinPropietario;

public class BsAsSur extends Barrio {

	private Propietario miDuenio;
	private BsAsNorte miNorte;

	public BsAsSur(){
		miDuenio = new SinPropietario();
		precioTerreno = 20000;
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}

    public void setPropietario(Jugador propietario) {
        this.miDuenio = propietario;
    }
}
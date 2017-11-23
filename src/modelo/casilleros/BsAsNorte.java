package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.estados.Propietario;
import modelo.casilleros.estados.SinPropietario;
import modelo.excepciones.ExcepcionCapitalInsuficiente;

public class BsAsNorte extends Barrio {

	private Propietario miDuenio;
	private BsAsSur miSur;

	public BsAsNorte(){
		this.miDuenio = new SinPropietario();
		precioTerreno = 25000;
		alquilerDefault = 2500;
		precioPrimeraCasa = 3500;
		precioSegundaCasa = 4000;
		precioHotel = 6000;

	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return (this.miDuenio == unPropietario);
	}

    public void setPropietario(Jugador propietario) {
        this.miDuenio = propietario;
    }

	public void construirCasa() throws ExcepcionCapitalInsuficiente {
		miDuenio.pagar(5000);
	}
}

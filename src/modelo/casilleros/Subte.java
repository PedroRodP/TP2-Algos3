package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.estados.Propietario;
import modelo.casilleros.estados.SinPropietario;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;

public class Subte implements Casillero {

	private Propietario miDuenio;

	public Subte(){
		this.miDuenio = new SinPropietario();
	}
	@Override
	public void caer(Jugador jugador, int velorDeLosDados) throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return (this.miDuenio == unPropietario);
	}

    public void setPropietario(Jugador propietario) {
        this.miDuenio = propietario;
    }
}

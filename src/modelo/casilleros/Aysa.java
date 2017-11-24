package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.estados.Propietario;
import modelo.excepciones.ExcepcionJugadorPreso;

public class Aysa implements Casillero {

    private Propietario miDuenio;

	@Override
	public void caer(Jugador jugador) throws ExcepcionJugadorPreso {
		// TODO Auto-generated method stub
		
	}

    @Override
    public boolean esDuenio(Propietario unPropietario) {
        return (this.miDuenio == unPropietario);
    }

    public void setPropietario(Jugador propietario) {
        this.miDuenio = propietario;
    }
    
    @Override
	public boolean equals(Object o){
		return (this.getClass()==o.getClass());
	}
}

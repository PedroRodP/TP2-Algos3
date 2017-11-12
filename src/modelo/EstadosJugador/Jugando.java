package modelo.EstadosJugador;

import modelo.Jugador;
import modelo.excepciones.JugadorEstaPresoException;

/**
 * Created by nico on 11/11/17.
 */
public class Jugando implements EstadoJugador {

	@Override
	public boolean esLibre() {
		return true;
	}
	
    @Override
    public int avanzar(int cantidadDePasos) throws JugadorEstaPresoException {
        return cantidadDePasos;
    }

    @Override
    public EstadoJugador siguienteEstado() {
    	return new Jugando();
    }
    
    @Override
    public void pagarFianza(Jugador jugador) {
    	//No debe abonar nada porque el jugador esta libre
    }
}

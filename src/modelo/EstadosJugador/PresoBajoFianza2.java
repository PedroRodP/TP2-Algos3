package modelo.EstadosJugador;

import modelo.Jugador;
import modelo.Tablero;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.JugadorEstaPresoException;

/**
 * Created by nico on 12/11/17.
 */
public class PresoBajoFianza2 implements EstadoJugador {

	private final double multa = 45000;

	@Override
	public boolean esLibre() {
		return false;
	}
	
    @Override
    public int avanzar(int cantidadDePasos) throws JugadorEstaPresoException {
        throw new JugadorEstaPresoException();
    }

    @Override
    public EstadoJugador siguienteEstado() {
        return new Jugando();
    }
    
    @Override
    public void pagarFianza(Jugador jugador) throws ExcepcionCapitalInsuficiente {
    	jugador.cobrar(multa);
    	jugador.cambiarEstado(this.siguienteEstado());
    }
}

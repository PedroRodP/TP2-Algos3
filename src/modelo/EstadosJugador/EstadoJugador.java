package modelo.EstadosJugador;

import modelo.Jugador;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.JugadorEstaPresoException;

/**
 * Created by nico on 11/11/17.
 */
public interface EstadoJugador {

	public boolean esLibre();
	
    public int avanzar(int cantidadDePasos) throws JugadorEstaPresoException;

    public EstadoJugador siguienteEstado();

	public void pagarFianza(Jugador jugador) throws ExcepcionCapitalInsuficiente;
}

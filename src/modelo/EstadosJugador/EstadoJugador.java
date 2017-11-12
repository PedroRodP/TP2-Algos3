package modelo.EstadosJugador;

import modelo.Jugador;
import modelo.Tablero;
import modelo.casilleros.Carcel;
import modelo.excepciones.*;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.JugadorEstaPresoException;

/**
 * Created by nico on 11/11/17.
 */
public interface EstadoJugador {

	boolean esLibre();
	
    int avanzar(int cantidadDePasos) throws JugadorEstaPresoException;

    EstadoJugador siguienteEstado() throws JugadorJugandoNoTieneMasEstados;

    void pagarFianza(Jugador esteJugador, Carcel laCarcel) throws ImposiblePagarFianzaPrimerTurnoExeption, JugadorNoEstaPreso, ExcepcionCapitalInsuficiente;

}

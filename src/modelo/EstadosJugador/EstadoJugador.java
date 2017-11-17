package modelo.EstadosJugador;

import modelo.Jugador;
import modelo.casilleros.Carcel;
import modelo.casilleros.Casillero;
import modelo.excepciones.*;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;

/**
 * Created by nico on 11/11/17.
 */
public interface EstadoJugador {
	
    Casillero avanzar(Casillero casillero) throws ExcepcionJugadorPreso;

    EstadoJugador siguienteEstado() throws ExcepcionJugadorYaEstaJugando;

    void pagarFianza(Jugador esteJugador, Carcel laCarcel) 
    		throws ExcepcionPagarFianzaNoCorresponde, ExcepcionCapitalInsuficiente;

}

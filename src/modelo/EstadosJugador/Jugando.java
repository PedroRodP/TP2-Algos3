package modelo.EstadosJugador;

import modelo.Jugador;
import modelo.Tablero;
import modelo.casilleros.Carcel;
import modelo.excepciones.ImposiblePagarFianzaPrimerTurnoExeption;
import modelo.excepciones.JugadorEstaPresoException;
import modelo.excepciones.JugadorJugandoNoTieneMasEstados;
import modelo.excepciones.JugadorNoEstaPreso;
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
    public void pagarFianza(Jugador esteJugador, Carcel laCarcel) throws ImposiblePagarFianzaPrimerTurnoExeption, JugadorNoEstaPreso {
        throw new JugadorNoEstaPreso();
    }

}

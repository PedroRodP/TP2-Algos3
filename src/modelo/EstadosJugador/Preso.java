package modelo.EstadosJugador;

import modelo.Jugador;
import modelo.casilleros.Carcel;
import modelo.excepciones.ImposiblePagarFianzaPrimerTurnoExeption;
import modelo.excepciones.JugadorEstaPresoException;
import modelo.excepciones.JugadorNoEstaPreso;

/**
 * Created by nico on 11/11/17.
 */
public class Preso implements EstadoJugador {

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
        return new PresoBajoFianza1();
    }

    @Override
    public void pagarFianza(Jugador esteJugador, Carcel laCarcel) throws ImposiblePagarFianzaPrimerTurnoExeption, JugadorNoEstaPreso {
        throw new ImposiblePagarFianzaPrimerTurnoExeption();
    }

}

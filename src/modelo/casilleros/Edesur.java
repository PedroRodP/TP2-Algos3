package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.estados.Propietario;
import modelo.casilleros.estados.SinPropietario;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;
import modelo.excepciones.ExcepcionNoExistePropietario;

public class Edesur implements Casillero {

    private Propietario propietario;

    public Edesur(){
    	this.propietario = new SinPropietario();
	}
	@Override
	public void caer(Jugador jugador, int valorDeLosDados) throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		double unMonto = 500 * valorDeLosDados;
		propietario.acreditar(unMonto);
		jugador.pagar(unMonto);
	}

    public void setPropietario(Jugador propietario) {
        this.propietario = propietario;
    }
}

package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.estados.Propietario;
import modelo.casilleros.estados.SinPropietario;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;
import modelo.excepciones.ExcepcionNoExistePropietario;

public class Tren implements Casillero {

	private Propietario miDuenio;
	private Subte subte;

	public Tren(){
		miDuenio = new SinPropietario();
	}
	@Override
	public void caer(Jugador jugador, int valorDeLosDados) throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		double unMonto = this.obtenerValorMultiplicidad() * valorDeLosDados;
		miDuenio.acreditar(unMonto); //acreditar debería recibir al jugador y pagar dentro de este metodo
		jugador.pagar(unMonto);
	}

	private int obtenerValorMultiplicidad() {
		return 450;
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return (this.miDuenio == unPropietario);
	}

    public void setPropietario(Jugador propietario) {
        this.miDuenio = propietario;
    }
}

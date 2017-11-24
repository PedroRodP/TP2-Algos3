package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.estados.Propietario;
import modelo.casilleros.estados.SinPropietario;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;
import modelo.excepciones.ExcepcionNoExistePropietario;

public class Edesur implements Casillero {

	private Propietario miDuenio;
	private Aysa aysa;

	public Edesur(){
		this.miDuenio = new SinPropietario();
		this.aysa = new Aysa();
	}

	@Override
	public void caer(Jugador jugador) throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		double unMonto = this.obtenerValorMultiplicidad() * (jugador.getUltimoValorDeDados());
		miDuenio.acreditar(unMonto);
		jugador.pagar(unMonto);
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return (this.miDuenio == unPropietario);
	}

	private int obtenerValorMultiplicidad() {
		int valorAgregado = 0;
		if (this.aysa.esDuenio(miDuenio))
			valorAgregado = 500;
		return 500 + valorAgregado;
	}

	public void setPropietario(Jugador propietario) {
		this.miDuenio = propietario;
	}

	public void setSocio(Aysa aysa){
		this.aysa = aysa;
	}
}

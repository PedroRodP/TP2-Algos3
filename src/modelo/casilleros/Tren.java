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
		subte = new Subte();
	}
	@Override
	public void caer(Jugador jugador) throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		double unMonto = this.obtenerValorMultiplicidad() * (jugador.getUltimoValorDeDados());
		miDuenio.acreditar(unMonto); //acreditar debería recibir al jugador y pagar dentro de este metodo
		jugador.pagar(unMonto);
	}

	private int obtenerValorMultiplicidad(){
		int valorAgregado = 0;
		if (this.subte.esDuenio(miDuenio))
			valorAgregado = 350;
		return (450 + valorAgregado);
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return (this.miDuenio == unPropietario);
	}

    public void setPropietario(Jugador propietario) {
        this.miDuenio = propietario;
    }

	public void setSocio(Subte socio) {
		this.subte = socio;
	}
	
	@Override
	public boolean equals(Object o){
		return (this.getClass()==o.getClass());
	}
}

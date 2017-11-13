package modelo.casilleros;

import modelo.Jugador;
import modelo.Tablero;
import modelo.excepciones.JugadorEstaPresoException;

public class Avance implements Casillero {

	public void avanzarDinamicamente(Jugador unJugador, Tablero unTablero, int valorSacadoEnDados) throws JugadorEstaPresoException {
		if(valorSacadoEnDados<7)
			unTablero.avanzar(unJugador, valorSacadoEnDados-2);
		else if (valorSacadoEnDados>6 && valorSacadoEnDados <11){
			
			unTablero.avanzar(unJugador,(int)(unJugador.balance()%valorSacadoEnDados));
		}
		else
			unTablero.avanzar(unJugador, (valorSacadoEnDados-unJugador.cantidadDeInmuebles()));
			
	}

}

package modelo.casilleros;

import modelo.Jugador;
import modelo.Tablero;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.JugadorEstaPresoException;

public class Avance implements Casillero {

	//Queda aca para no complejizar las pruebas de avance
	public void avanzarDinamicamente(Jugador unJugador, Tablero unTablero, int velorDeLosDados) throws JugadorEstaPresoException, ExcepcionCapitalInsuficiente {
		if(velorDeLosDados<7)
			unTablero.avanzar(unJugador, velorDeLosDados-2);
		else if (velorDeLosDados>6 && velorDeLosDados <11){
			
			unTablero.avanzar(unJugador,(int)(unJugador.balance()%velorDeLosDados));
		}
		else
			unTablero.avanzar(unJugador, (velorDeLosDados-unJugador.cantidadDeInmuebles()));
			
	}

	@Override
	public void hazLoTuyo(Jugador unJugador, Tablero unTablero, int velorDeLosDados)
			throws JugadorEstaPresoException, ExcepcionCapitalInsuficiente {
		this.avanzarDinamicamente(unJugador, unTablero, velorDeLosDados);
	}

	
}

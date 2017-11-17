package modelo.casilleros;

import modelo.Jugador;
import modelo.Tablero;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;

public class Retroceso implements Casillero {

	//Queda aca para no complejizar las pruebas de avance
	public void retrocederDinamicamente(Jugador unJugador, Tablero unTablero, int velorDeLosDados) throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente {
		if(velorDeLosDados<7)
			unTablero.avanzar(unJugador, Math.abs(velorDeLosDados-2)*-1);
		else if (velorDeLosDados>6 && velorDeLosDados <11){
			
			unTablero.avanzar(unJugador,(int) (Math.abs(unJugador.getCapital()%velorDeLosDados)*-1));
		}
		else
			unTablero.avanzar(unJugador, Math.abs(velorDeLosDados-unJugador.cantidadDeInmuebles())*-1);
			
	}

	@Override
	public void caer(Jugador unJugador, Tablero unTablero, int velorDeLosDados)
			throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente {
		this.retrocederDinamicamente(unJugador, unTablero, velorDeLosDados);
	}



}

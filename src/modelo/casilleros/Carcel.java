package modelo.casilleros;

import modelo.Jugador;
import modelo.Tablero;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.JugadorEstaPresoException;
import modelo.excepciones.JugadorJugandoNoTieneMasEstados;

import java.util.ArrayList;

public class Carcel implements Casillero {

    private final double costoFianza = 1000;

    private ArrayList<Jugador> listaDePresos;

    public Carcel(){
        listaDePresos = new ArrayList<>();
    }


    public void cumplirRonda() throws JugadorJugandoNoTieneMasEstados {
        for (Jugador unPreso: listaDePresos) {
            unPreso.siguienteEstado();
        }

        this.verificarCondenas();
    }

    private void verificarCondenas() {
        ArrayList<Jugador> listaAuxiliar;
        listaAuxiliar = (ArrayList<Jugador>) this.listaDePresos.clone();

        //Recorro la lista de Presos para liberar los que cumplieron los turnos.
        for (Jugador unPreso: listaAuxiliar) {
            if (this.cumplioCondena(unPreso))
                this.excarcelar(unPreso);
        }
    }

    private boolean cumplioCondena(Jugador unPreso) {
        try {
            unPreso.avanzar(0);
            return true;
        } catch (JugadorEstaPresoException e) {
            return false;
        }
    }

    private void excarcelar(Jugador unPreso) {
        unPreso.recobrarLibertad();
        listaDePresos.remove(unPreso);
    }

    public int cantidadDePresos() {
        return listaDePresos.size();
    }

    public void cobrarFianza(Jugador unJugador) throws ExcepcionCapitalInsuficiente {
        if (costoFianza > unJugador.getCapital())
            throw new ExcepcionCapitalInsuficiente();
        unJugador.pagar(costoFianza);
        this.excarcelar(unJugador);
    }

	@Override
	public void caer(Jugador unJugador, Tablero unTablero, int velorDeLosDados) throws JugadorEstaPresoException {
		
	  this.arrestar(unJugador);
		
	}
	
	//Queda el metodo arrestar solamente para no complejizar las pruebas de la Carcel

	public void arrestar(Jugador unJugador) {
	     listaDePresos.add(unJugador);
	     unJugador.irPreso();
	}
}

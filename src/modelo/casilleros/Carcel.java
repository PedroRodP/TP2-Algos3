package modelo.casilleros;

import modelo.Jugador;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;
import modelo.excepciones.ExcepcionJugadorYaEstaJugando;

import java.util.ArrayList;

public class Carcel implements Casillero {

    private final double costoFianza = 1000;

    private ArrayList<Jugador> listaDePresos;

    public Carcel(){
        listaDePresos = new ArrayList<>();
    }


    public void cumplirRonda() throws ExcepcionJugadorYaEstaJugando {
        for (Jugador unPreso: listaDePresos) {
            unPreso.cumplirCondena();
        }

        this.verificarCondenas();
    }

    @SuppressWarnings("unchecked")
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
        	Casillero casilleroX = new Salida();
            unPreso.avanzar(casilleroX);
            return true;
        } catch (ExcepcionJugadorPreso e) {
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
        
        unJugador.pagar(costoFianza);
        this.excarcelar(unJugador);
    }

	@Override
	public void caer(Jugador jugador, int velorDeLosDados) throws ExcepcionJugadorPreso {
		
	  this.arrestar(jugador);
		
	}

	public void arrestar(Jugador unJugador) {
	     listaDePresos.add(unJugador);
	     unJugador.irPreso();
	}
}

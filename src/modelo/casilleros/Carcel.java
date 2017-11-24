package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.estados.Propietario;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;
import modelo.excepciones.ExcepcionJugadorYaEstaJugando;
import modelo.excepciones.ExcepcionNoExistePropietario;

import java.util.ArrayList;

public class Carcel implements Casillero {

    private final double costoFianza = 45000;

    private ArrayList<Jugador> listaDePresos;

    public Carcel(){
        listaDePresos = new ArrayList<>();
    }


    public void cumplirRonda() throws ExcepcionJugadorYaEstaJugando, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
        for (Jugador unPreso: listaDePresos) {
            unPreso.cumplirCondena();
        }

        this.verificarCondenas();
    }

    @SuppressWarnings("unchecked")
	private void verificarCondenas() throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
        ArrayList<Jugador> listaAuxiliar;
        listaAuxiliar = (ArrayList<Jugador>) this.listaDePresos.clone();

        //Recorro la lista de Presos para liberar los que cumplieron los turnos.
        for (Jugador unPreso: listaAuxiliar) {
            if (this.cumplioCondena(unPreso))
                this.excarcelar(unPreso);
        }
    }

    private boolean cumplioCondena(Jugador unPreso) throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
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
	public void caer(Jugador jugador) throws ExcepcionJugadorPreso {
		
	  this.arrestar(jugador);
		
	}

    @Override
    public boolean esDuenio(Propietario unPropietario) {
        return false;
    }

    public void arrestar(Jugador unJugador) {
	     listaDePresos.add(unJugador);
	     unJugador.irPreso(this);
	}
}

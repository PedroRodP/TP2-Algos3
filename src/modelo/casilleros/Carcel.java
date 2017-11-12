package modelo.casilleros;

import modelo.Jugador;

import java.util.ArrayList;

public class Carcel implements Casillero {
    ArrayList<Jugador> listaDePresos;

    public Carcel(){
        listaDePresos = new ArrayList<>();
    }

    public void arrestar(Jugador unJugador) {
        listaDePresos.add(unJugador);
        unJugador.irPreso();
    }
}

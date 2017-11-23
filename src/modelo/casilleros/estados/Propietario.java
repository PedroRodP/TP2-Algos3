package modelo.casilleros.estados;

import modelo.Jugador;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionNoExistePropietario;

public interface Propietario {

    void recibirPagoDe(Jugador unJugador, double unMonto) throws ExcepcionNoExistePropietario, ExcepcionCapitalInsuficiente;

    void acreditar(double unMonto) throws ExcepcionNoExistePropietario, ExcepcionCapitalInsuficiente;
    
    void pagar(double unMonto) throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario;
}

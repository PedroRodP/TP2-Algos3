package modelo.casilleros.estados;

import modelo.Jugador;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionNoExistePropietario;

public class SinPropietario implements Propietario {

    public SinPropietario() {}

    @Override
    public void acreditar(double unMonto) throws ExcepcionNoExistePropietario {
        throw  new ExcepcionNoExistePropietario();
    }

    @Override
    public void recibirPagoDe(Jugador unJugador, double unMonto) throws ExcepcionNoExistePropietario, ExcepcionCapitalInsuficiente {
        throw  new ExcepcionNoExistePropietario();
    }

    @Override
    public void pagar(double unMonto) throws ExcepcionNoExistePropietario {
    	throw new ExcepcionNoExistePropietario();
    }
}

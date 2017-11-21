package modelo.casilleros.estados;

import modelo.casilleros.Casillero;
import modelo.excepciones.ExcepcionNoExistePropietario;

public class SinPropietario implements Propietario {

    public SinPropietario() {}

    @Override
    public void acreditar(double unMonto) throws ExcepcionNoExistePropietario {
        throw new ExcepcionNoExistePropietario();
    }
}

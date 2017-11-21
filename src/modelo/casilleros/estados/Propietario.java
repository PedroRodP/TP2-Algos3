package modelo.casilleros.estados;

import modelo.excepciones.ExcepcionNoExistePropietario;

public interface Propietario {

    void acreditar(double unMonto) throws ExcepcionNoExistePropietario;
}

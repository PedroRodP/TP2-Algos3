package modelo.casilleros.estados;

import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionNoExistePropietario;

public interface Propietario {

    void acreditar(double unMonto) throws ExcepcionNoExistePropietario;
    
    void pagar(double unMonto) throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario;
}

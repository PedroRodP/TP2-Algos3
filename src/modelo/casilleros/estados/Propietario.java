package modelo.casilleros.estados;

import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionNoExistePropietario;

public interface Propietario {

    void pagar(double monto) throws ExcepcionCapitalInsuficiente;

    void acreditar(double unMonto) throws ExcepcionNoExistePropietario;
}

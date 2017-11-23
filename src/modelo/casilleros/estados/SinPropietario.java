package modelo.casilleros.estados;

import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionNoExistePropietario;

public class SinPropietario implements Propietario {

    public SinPropietario() {}

    @Override
    public void pagar(double monto) throws ExcepcionCapitalInsuficiente {
        //throw new ExcepcionNoExistePropietario();
    }

    @Override
    public void acreditar(double unMonto) throws ExcepcionNoExistePropietario {
        //throw new ExcepcionNoExistePropietario();
    }
}

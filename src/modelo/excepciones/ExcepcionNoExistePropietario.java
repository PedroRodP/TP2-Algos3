package modelo.excepciones;

/**
 * Created by nico on 20/11/17.
 */
public class ExcepcionNoExistePropietario extends Throwable {
    public String mensaje(){
        return "No existe propietario. ";
    }
}

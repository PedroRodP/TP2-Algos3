package modelo.excepciones;

/**
 * Created by nico on 20/11/17.
 */
@SuppressWarnings("serial")
public class ExcepcionNoExistePropietario extends Throwable {
    public String mensaje(){
        return "No existe propietario. ";
    }
}

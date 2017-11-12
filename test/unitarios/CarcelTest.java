package unitarios;

import modelo.Jugador;
import modelo.casilleros.Carcel;
import org.junit.Test;

/**
 * Created by nico on 12/11/17.
 */
public class CarcelTest {
    @Test
    public void test01(){
        Jugador jugadorAzul = new Jugador();
        Carcel laCarcel = new Carcel();

        laCarcel.arrestar(jugadorAzul);

        laCarcel.cumplirRonda();
        laCarcel.cumplirRonda();
        laCarcel.cumplirRonda();
    }
}

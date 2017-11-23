package modelo;

import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionNoExistePropietario;

public interface Pasada {

	public void otorgarPremio(Jugador jugador) throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario;

	public Pasada incrementar();
}

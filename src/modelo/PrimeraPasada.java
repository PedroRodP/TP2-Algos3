package modelo;

import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionNoExistePropietario;

public class PrimeraPasada implements Pasada {

	private final double premio = 50000;
	
	@Override
	public void otorgarPremio(Jugador jugador) throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		
		jugador.acreditar(premio);
	}
	
	@Override
	public Pasada incrementar() {
		
		return new SegundaPasada();
	}
}

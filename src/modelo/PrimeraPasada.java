package modelo;

public class PrimeraPasada implements Pasada {

	private final double premio = 50000;
	
	@Override
	public void otorgarPremio(Jugador jugador) {
		
		jugador.acreditar(premio);
	}
	
	@Override
	public Pasada incrementar() {
		
		return new SegundaPasada();
	}
}

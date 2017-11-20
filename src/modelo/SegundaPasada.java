package modelo;

public class SegundaPasada implements Pasada {

	private final double premio = 30000;
		
		@Override
		public void otorgarPremio(Jugador jugador) {
			
			jugador.acreditar(premio);
		}
		
		@Override
		public Pasada incrementar() {
			
			return new PasadaSinPremio();
		}
}

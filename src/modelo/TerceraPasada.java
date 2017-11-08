package modelo;

public class TerceraPasada implements Pasada {
		
		@Override
		public void otorgarPremio(Jugador jugador) {
			
			//No acredita premio
		}
		
		@Override
		public Pasada incrementar() {
			
			//No hay necesidad de incrementar pasadas luego de la tercera
			return new TerceraPasada();
		}
}

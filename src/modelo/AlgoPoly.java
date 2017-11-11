package modelo;

public class AlgoPoly {

	private Tablero tablero = new Tablero();
	private Jugador jugadorRojo;
	private Jugador jugadorAmarillo;
	private Jugador jugadorAzul;
	
	public AlgoPoly() {
		
		jugadorRojo = new Jugador();
		jugadorAmarillo = new Jugador();
		jugadorAzul = new Jugador();
		jugadorRojo.setTablero(tablero);
		jugadorAmarillo.setTablero(tablero);
		jugadorAzul.setTablero(tablero);
	}
	

	
}

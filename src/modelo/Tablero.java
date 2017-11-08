package modelo;

import java.util.ArrayList;
import java.util.List;

import modelo.casilleros.Casillero;

public class Tablero {
	
	private List<Casillero> casilleros = new ArrayList<Casillero>();
	
	public void agregarCasillero(Casillero casillero) {
		casilleros.add(casillero);
	}
}

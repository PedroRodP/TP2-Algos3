package modelo;

import java.util.ArrayList;
import java.util.List;

import modelo.casilleros.Transitable;

public class Tablero {
	
	private List<Transitable> casilleros = new ArrayList<Transitable>();
	
	public void agregarCasillero(Transitable casillero) {
		casilleros.add(casillero);
	}
}

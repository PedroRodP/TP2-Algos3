package modelo.casilleros;

import java.util.LinkedList;

import modelo.Jugador;
import modelo.Tablero;
import modelo.casilleros.estados.Propietario;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;
import modelo.excepciones.ExcepcionNoExistePropietario;

public class Avance implements Casillero {
	
/*	Tablero tablero;
	
	public Avance(Tablero referencia) {
		
		tablero = referencia;
	}
*/ 
	private LinkedList<Casillero> casilleros = new LinkedList<Casillero>();
	
	public Avance(){
		
		casilleros.add(this);
		casilleros.add(new Subte());
		casilleros.add(new CordobaNorte());
		casilleros.add(new Impuesto());
		casilleros.add(new SantaFe());
		casilleros.add(new Aysa());
		casilleros.add(new SaltaNorte());
		casilleros.add(new SaltaSur());
		casilleros.add(new Policia());
		casilleros.add(new Tren());
		casilleros.add(new Neuquen());
		casilleros.add(this);
		casilleros.add(new Tucuman());
		casilleros.add(new Salida());
		casilleros.add(new Quini6());
		casilleros.add(new BsAsSur());
		casilleros.add(new Edesur());
		casilleros.add(new BsAsNorte());
		casilleros.add(new Carcel());
		casilleros.add(new CordobaSur());
		
	}
	
	private void avanzarDinamicamente(Jugador jugador, int valorDados) throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		
		if (valorDados <= 6) {
			
			jugador.avanzar(casilleros.get(valorDados-2));
		
		} else if (valorDados > 6 && valorDados <= 10) {
			
			jugador.avanzar(casilleros.get((int)Math.abs(jugador.getCapital() % valorDados)));
			
		} else {
			
			jugador.avanzar(casilleros.get(Math.abs(valorDados - jugador.cantidadDeInmuebles())));
			
		}	
	}

	@Override
	public void caer(Jugador jugador)
			throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		
		this.avanzarDinamicamente(jugador, jugador.getUltimoValorDeDados());
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}
	


}

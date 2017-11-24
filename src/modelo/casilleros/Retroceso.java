package modelo.casilleros;

import java.util.LinkedList;

import modelo.Jugador;
import modelo.Tablero;
import modelo.casilleros.estados.Propietario;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionJugadorPreso;
import modelo.excepciones.ExcepcionNoExistePropietario;

public class Retroceso implements Casillero {
	
	Tablero tablero;
	
/*	public Retroceso(Tablero referencia) {
		
		tablero = referencia;
	}
*/	
	private LinkedList<Casillero> casilleros = new LinkedList<Casillero>();
	
	public Retroceso(){
		
		casilleros.add(this);
		casilleros.add(new Neuquen());
		casilleros.add(new Tren());
		casilleros.add(new Policia());
		casilleros.add(new SaltaSur());
		casilleros.add(new SaltaNorte());
		casilleros.add(new Aysa());
		casilleros.add(new SantaFe());
		casilleros.add(new Impuesto());
		casilleros.add(new CordobaNorte());
		casilleros.add(new Subte());
		casilleros.add(this);
		casilleros.add(new CordobaSur());
		casilleros.add(new Carcel());
		casilleros.add(new BsAsNorte());
		casilleros.add(new Edesur());
		casilleros.add(new BsAsSur());
		casilleros.add(new Quini6());
		casilleros.add(new Salida());		
		casilleros.add(new Tucuman());
				
		
	}
	private void retrocederDinamicamente(Jugador jugador, int valorDados) throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		
		if (valorDados <= 6) {
			
			jugador.avanzar(casilleros.get(Math.abs(valorDados-2)));
		
		} else if (valorDados > 6 && valorDados <= 10) {
			
			jugador.avanzar(casilleros.get((int)Math.abs(jugador.getCapital() % valorDados)));
			
		} else {
			
			jugador.avanzar(casilleros.get(Math.abs(valorDados - jugador.cantidadDeInmuebles())));
			
		}	
	}

	@Override
	public void caer(Jugador jugador)
			throws ExcepcionJugadorPreso, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		
		this.retrocederDinamicamente(jugador, jugador.getUltimoValorDeDados());
	}

	@Override
	public boolean esDuenio(Propietario unPropietario) {
		return false;
	}


}

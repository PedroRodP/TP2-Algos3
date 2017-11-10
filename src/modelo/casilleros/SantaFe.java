package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.estados.AdministradorDeCompra;
import modelo.casilleros.estados.Estado;
import modelo.casilleros.estados.RegistroDeInmuebles;
import modelo.excepciones.ExcepcionTerrenoOcupado;

public class SantaFe extends Barrio implements Transitable {

	
	public SantaFe(){
		
		precioTerreno = 15000;
		
	}

	public void venderTerreno() {
		
	}
	
	public double calcularReembolso() {
		
		double adicional = registro.getValorEdificios();
		double total = precioTerreno + adicional;
		
		return (total * 85 / 100);
	}
	
	public void cobrar(Jugador jugador) {
		
		registro.cobrar(jugador);
	}
	
	public void edificar() {
		
		registro.edificar();
	}
}

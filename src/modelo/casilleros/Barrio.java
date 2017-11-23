package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.estados.AdministradorDeCompra;
import modelo.casilleros.estados.Propietario;
import modelo.casilleros.estados.RegistroDeInmuebles;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionNoExistePropietario;
import modelo.excepciones.ExcepcionTerrenoCompleto;
import modelo.excepciones.ExcepcionTerrenoOcupado;

public abstract class Barrio implements Casillero {
	
	protected double alquilerDefault;
	protected double precioTerreno;
	protected double precioPrimeraCasa;
	protected double precioSegundaCasa;
	protected double precioHotel;
	protected AdministradorDeCompra administrador = new AdministradorDeCompra();
	protected RegistroDeInmuebles registro;
	
	
	@Override
	public void caer(Jugador jugador, int valorDados) throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		
		try {
			this.serComprado(jugador);
			
		} catch (ExcepcionTerrenoOcupado e) {
			
			this.serAlquilado(jugador);
		}
	}
	
	public void serComprado(Jugador jugador) throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente {
		
		administrador.comprarTerreno(jugador, precioTerreno);
	}
	
	public void serVendido(Jugador jugador) throws ExcepcionNoExistePropietario {
		
		administrador.venderTerreno(jugador, precioTerreno);
	}
	
	public void serAlquilado(Jugador jugador) throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		
		double monto = registro.calcularAlquiler();
		jugador.pagar(monto);
		
		Propietario duenio = this.getPropietario();
		duenio.acreditar(monto);
	}
	
	public void edificar() throws ExcepcionTerrenoCompleto {
		
		registro.edificarEn(this);
	}
	
	public double getPrecio(){
		return precioTerreno;
	}

	public Propietario getPropietario() {
		return administrador.getDuenio();
	}
	
	public double getPrecioPrimeraCasa() {
		return precioPrimeraCasa;
	}
	
	public double getPrecioSegundaCasa() {
		return precioSegundaCasa;
	}
	
	public double getPrecioHotel() {
		return precioHotel;
	}
	
	public double getAlquilerDefault() {
		return alquilerDefault;
	}

	//Metodo para intercambios
	public void setNuevoDuenio(Propietario otroJugador) {
		administrador.setDuenio(otroJugador);
	}
}

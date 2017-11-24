package modelo.casilleros;

import modelo.Jugador;
import modelo.casilleros.estados.AdministradorDeCompra;
import modelo.casilleros.estados.Propietario;
import modelo.casilleros.estados.RegistroDeInmuebles;
import modelo.excepciones.*;

public abstract class Barrio implements Casillero {
	
	protected double alquilerDefault;
	protected double precioTerreno;
	protected double precioPrimeraCasa;
	protected double precioSegundaCasa;
	protected double precioHotel;
	protected double precioConstruccionCasa;
	protected double precioConstruccionHotel;
	protected AdministradorDeCompra administrador = new AdministradorDeCompra();
	protected RegistroDeInmuebles registro;

	@Override
	public void caer(Jugador jugador) throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		double unMonto = registro.calcularAlquiler();
		administrador.getDuenio().recibirPagoDe(jugador, unMonto);
	}
	
	public void serComprado(Jugador jugador) throws ExcepcionTerrenoOcupado, ExcepcionCapitalInsuficiente {
		
		administrador.comprarTerreno(jugador, precioTerreno);
	}
	
	public void serVendido(Jugador jugador) throws ExcepcionNoExistePropietario, ExcepcionCapitalInsuficiente {
		
		administrador.venderTerreno(jugador, precioTerreno);
	}
	
	public void serAlquilado(Jugador jugador) throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		
		double monto = registro.calcularAlquiler();

		Propietario duenio = this.getPropietario();
		duenio.recibirPagoDe(jugador, monto);
	}
	
	public void edificar() throws ExcepcionTerrenoCompleto, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		
		registro.edificarEn(this);
	}

	public void edificarHotel() throws ExcepcionTerrenoCompleto, ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario, ExcepcionNoSePuedeConstruirHotelAun {
		if (registro.sePuedeConstruirHotel())
			registro.edificarEn(this);
		else
			throw new ExcepcionNoSePuedeConstruirHotelAun();
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

	public double getPrecioConstruccionCasa() {
		return precioConstruccionCasa;
	}
	
	public double getPrecioConstruccionHotel() {
		return precioConstruccionHotel;
	}
	
}

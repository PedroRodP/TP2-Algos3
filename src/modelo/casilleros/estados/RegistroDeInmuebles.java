package modelo.casilleros.estados;

import modelo.casilleros.Barrio;
import modelo.excepciones.ExcepcionCapitalInsuficiente;
import modelo.excepciones.ExcepcionNoExistePropietario;
import modelo.excepciones.ExcepcionTerrenoCompleto;

public class RegistroDeInmuebles {
	
	Construccion edificio;
	
	public RegistroDeInmuebles(double alquilerDefault) {
		edificio = new SinEdificar(alquilerDefault);
	}

	public double calcularAlquiler() throws ExcepcionCapitalInsuficiente, ExcepcionNoExistePropietario {
		return (edificio.getValorDeAlquiler());
	}
	
	public void edificarEn(Barrio barrio) throws ExcepcionTerrenoCompleto {
		edificio = edificio.construirEn(barrio);
	}
	
	public double calcularReembolsoDeEdificios() {
		return 100;
	}
	
}

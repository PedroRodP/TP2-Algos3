package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import modelo.AlgoPoly;

public class BotonArrojarDadosHandler implements EventHandler<ActionEvent> {

	AlgoPoly aPoly;
	Button miBoton;
	Button botonTurno;
	
	public BotonArrojarDadosHandler(AlgoPoly aPoly, Button miBoton, Button botonTurno) {
		this.aPoly = aPoly;
		this.miBoton = miBoton;
		this.botonTurno = botonTurno;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		
		this.aPoly.opcionMoverse(this.aPoly.arrojarDados());
		
		this.miBoton.setDisable(true);
		this.botonTurno.setDisable(false);
	}
	
}

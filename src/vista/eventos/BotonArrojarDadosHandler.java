package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import modelo.AlgoPoly;

public class BotonArrojarDadosHandler implements EventHandler<ActionEvent> {

	AlgoPoly aPoly;
	Button miBoton;
	
	public BotonArrojarDadosHandler(AlgoPoly aPoly, Button miBoton) {
		this.aPoly = aPoly;
		this.miBoton = miBoton;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		
		this.aPoly.opcionMoverse();
		
		this.miBoton.setDisable(true);
	}
	
}

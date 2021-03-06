package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import modelo.AlgoPoly;

public class BotonPagarFianzaHandler implements EventHandler<ActionEvent> {

	AlgoPoly aPoly;
	Button miBoton;
	
	public BotonPagarFianzaHandler(AlgoPoly aPoly, Button miBoton) {
		this.aPoly = aPoly;
		this.miBoton = miBoton;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		
		this.aPoly.opcionPagarFianza();
		this.miBoton.setDisable(true);
	}
	
}

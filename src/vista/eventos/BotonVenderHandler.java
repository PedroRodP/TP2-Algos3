package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import modelo.AlgoPoly;

public class BotonVenderHandler implements EventHandler<ActionEvent> {

	AlgoPoly aPoly;
	Button miBoton;
	
	public BotonVenderHandler(AlgoPoly aPoly, Button miBoton) {
		this.aPoly = aPoly;
		this.miBoton = miBoton;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		
		this.aPoly.opcionVenderPropiedades();
		
		this.miBoton.setDisable(true);
	}
	
}

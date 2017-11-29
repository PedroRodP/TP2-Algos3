package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import modelo.AlgoPoly;

public class BotonEdificarHandler implements EventHandler<ActionEvent> {

	AlgoPoly aPoly;
	Button miBoton;
	
	public BotonEdificarHandler(AlgoPoly aPoly, Button miBoton) {
		this.aPoly = aPoly;
		this.miBoton = miBoton;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		
		this.aPoly.opcionEdificar();
		
		this.miBoton.setDisable(true);
	}
	
}

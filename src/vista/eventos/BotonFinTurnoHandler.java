package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import modelo.AlgoPoly;

public class BotonFinTurnoHandler implements EventHandler<ActionEvent>{

	AlgoPoly aPoly;
	Button miBoton;
	Button boton1;
	Button boton2;
	Button boton3;
	Button boton4;
	
	public BotonFinTurnoHandler(AlgoPoly aPoly, Button miBoton, Button boton1, Button boton2, Button boton3, Button boton4) {
		this.aPoly = aPoly;
		this.miBoton = miBoton;
		this.miBoton.setDisable(true);
		this.boton1 = boton1;
		this.boton2 = boton2;
		this.boton3 = boton3;
		this.boton4 = boton4;
	}
	
	@Override
	public void handle(ActionEvent actionEvent) {
		
		this.aPoly.jugar();
		
		//Reinicia los botones
		this.boton1.setDisable(false);
		this.boton2.setDisable(false);
		this.boton3.setDisable(false);
		this.boton4.setDisable(false);
		this.miBoton.setDisable(true);
	}
	
}

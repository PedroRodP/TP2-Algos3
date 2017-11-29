package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Acerca de...");
        alert.setHeaderText("ALGOPOLY");
        String mensaje = "AlgoPoly es un juego para 3 jugadores creado para el trabajo practico 2 de Algoritmos 3";
        alert.setContentText(mensaje);
        alert.show();
    }
}

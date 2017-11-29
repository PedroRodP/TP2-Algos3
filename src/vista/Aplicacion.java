package vista;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import vista.eventos.AplicacionOnKeyPressEventHandler;

public class Aplicacion extends Application {

	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(final Stage stage) {
		
		stage.setTitle("AlgoPoly");
		
		AlgoPoly aPoly = new AlgoPoly();
		
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, aPoly);
        Scene escenaJuego = new Scene(contenedorPrincipal, 800, 600);

        ContenedorBienvenidos contenedorBienvenidos = new ContenedorBienvenidos(stage, escenaJuego);
        Scene escenaBienvenidos = new Scene(contenedorBienvenidos, 640, 480);

        //Handler para manejar el modo pantalla completa con ESC
        AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);
        
        stage.setScene(escenaBienvenidos);
        stage.show();
	}
	
}

package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.Jugador;
import vista.eventos.BotonArrojarDadosHandler;
import vista.eventos.BotonEdificarHandler;
import vista.eventos.BotonProximoTurnoHandler;
import vista.eventos.BotonPagarFianzaHandler;
import vista.eventos.BotonVenderHandler;

public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu menuBar;
    AlgoPoly aPoly;
    Canvas canvasCentral;
    VBox contenedorCentral;

    public ContenedorPrincipal(Stage stage, AlgoPoly aPoly) {
        this.setMenu(stage);
        this.setCentro(aPoly);
        this.setConsola();
    	this.setBotonera(aPoly);
    }

    private void setBotonera(AlgoPoly aPoly) {

    	//Creacion de todos los botones
    	
        Button botonTurno = new Button();
        botonTurno.setText("Proximo turno");
    	
        Button botonDados = new Button();
        botonDados.setText("Arrojar dados");
        
        Button botonFianza = new Button();
        botonFianza.setText("Pagar fianza");
        
        Button botonVender = new Button();
        botonVender.setText("Vender propiedades");
        
        Button botonEdificar = new Button();
        botonEdificar.setText("Edificar");
    	
    	//Asignacion de controladores

        BotonArrojarDadosHandler dadosButtonHandler = new BotonArrojarDadosHandler(aPoly, botonDados, botonTurno);
        botonDados.setOnAction(dadosButtonHandler);

        BotonPagarFianzaHandler fianzaButtonHandler = new BotonPagarFianzaHandler(aPoly, botonFianza);
        botonFianza.setOnAction(fianzaButtonHandler);
        

        BotonVenderHandler venderButtonHandler = new BotonVenderHandler(aPoly, botonVender);
        botonVender.setOnAction(venderButtonHandler);
        
        BotonEdificarHandler edificarButtonHandler = new BotonEdificarHandler(aPoly, botonEdificar);
        botonEdificar.setOnAction(edificarButtonHandler);
        
        BotonProximoTurnoHandler turnoButtonHandler = new BotonProximoTurnoHandler(aPoly, botonTurno, botonFianza, botonVender, botonEdificar, botonDados);
        botonTurno.setOnAction(turnoButtonHandler);
        

        //Botonera izquierda
        
        VBox contenedorVertical = new VBox(botonFianza, botonVender, botonEdificar, botonDados);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));
        contenedorVertical.setStyle("-fx-background-color: darkred;");

        this.setLeft(contenedorVertical);
        
        
        //Botonera derecha

        VBox contenedorVertical2 = new VBox(botonTurno);
        contenedorVertical2.setSpacing(10);
        contenedorVertical2.setPadding(new Insets(15));
        contenedorVertical2.setStyle("-fx-background-color: darkred;");

        this.setRight(contenedorVertical2);

    }

    private void setMenu(Stage stage) {
    	
        this.menuBar = new BarraDeMenu(stage);
        
        this.setTop(menuBar);
    }

    private void setCentro(AlgoPoly aPoly) {

        canvasCentral = new Canvas(360, 360);
        
        Jugador jugadorRojo = new Jugador();
        Jugador jugadorAzul = new Jugador();
        Jugador jugadorAmarillo = new Jugador();
        
        VistaJugador vistaJugadorRojo = new VistaJugador(canvasCentral, jugadorRojo, Color.DARKRED);
        VistaJugador vistaJugadorAzul = new VistaJugador(canvasCentral, jugadorAzul, Color.DARKBLUE);
        VistaJugador vistaJugadorAmarillo = new VistaJugador(canvasCentral, jugadorAmarillo, Color.YELLOW);
        
        vistaJugadorRojo.dibujar(0);
        vistaJugadorAzul.dibujar(0);
        vistaJugadorAmarillo.dibujar(0);

        contenedorCentral = new VBox(canvasCentral);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(20);
        contenedorCentral.setPadding(new Insets(25));
        
        Image imagen = new Image("file:src/vista/imagenes/fondo.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo));

        this.setCenter(contenedorCentral);
    }

	private void setConsola() {

        this.actualizarConsola("Consola...");
    }
    
    public void actualizarConsola(String nuevoTexto) {
    	
    	Label etiqueta = this.crearEtiquetaDeConsola(nuevoTexto);
    	
    	VBox contenedorConsola = this.crearVBoxDeConsola(etiqueta);
    	
    	this.setBottom(contenedorConsola);
    	
    }

	private Label crearEtiquetaDeConsola(String nuevoTexto) {
		
        Label etiqueta = new Label();
        etiqueta.setText(nuevoTexto);
        etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 15));
        etiqueta.setTextFill(Color.DARKRED);
		
		return etiqueta;
	}
	
    private VBox crearVBoxDeConsola(Label etiqueta) {
		
        VBox contenedorConsola = new VBox(etiqueta);
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));
        contenedorConsola.setStyle("-fx-background-color: beige;");
    	
		return contenedorConsola;
	}

	public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }

}

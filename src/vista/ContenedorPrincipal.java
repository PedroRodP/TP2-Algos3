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
import vista.eventos.BotonArrojarDadosHandler;
import vista.eventos.BotonEdificarHandler;
import vista.eventos.BotonFinTurnoHandler;
import vista.eventos.BotonPagarFianzaHandler;
import vista.eventos.BotonVenderHandler;

public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu menuBar;
    AlgoPoly aPoly;
//    Canvas canvasCentral;
    VBox contenedorCentral;

    public ContenedorPrincipal(Stage stage, AlgoPoly aPoly) {
        this.setMenu(stage);
//        this.setCentro(aPoly);
        this.setConsola();
    	this.setBotonera(aPoly);
    	this.setBotonFinTurno(aPoly);
    }

    private void setBotonera(AlgoPoly aPoly) {

    	//Creacion de todos los botones
    	
        Button botonTurno = new Button();
        botonTurno.setText("Terminar turno");
    	
        Button botonDados = new Button();
        botonDados.setText("Arrojar dados");
        
        Button botonFianza = new Button();
        botonFianza.setText("Pagar fianza");
        
        Button botonVender = new Button();
        botonVender.setText("Vender propiedades");
        
        Button botonEdificar = new Button();
        botonEdificar.setText("Edificar");
    	
    	//Asignacion de controladores

        BotonArrojarDadosHandler dadosButtonHandler = new BotonArrojarDadosHandler(aPoly, botonDados);
        botonDados.setOnAction(dadosButtonHandler);

        BotonPagarFianzaHandler fianzaButtonHandler = new BotonPagarFianzaHandler(aPoly, botonFianza);
        botonFianza.setOnAction(fianzaButtonHandler);
        

        BotonVenderHandler venderButtonHandler = new BotonVenderHandler(aPoly, botonVender);
        botonVender.setOnAction(venderButtonHandler);
        
        BotonEdificarHandler edificarButtonHandler = new BotonEdificarHandler(aPoly, botonEdificar);
        botonEdificar.setOnAction(edificarButtonHandler);
        
        BotonFinTurnoHandler turnoButtonHandler = new BotonFinTurnoHandler(aPoly, botonTurno, botonFianza, botonVender, botonEdificar, botonDados);
        botonTurno.setOnAction(turnoButtonHandler);
        

        //Botonera izquierda
        
        VBox contenedorVertical = new VBox(botonFianza, botonVender, botonEdificar, botonDados);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));

        this.setLeft(contenedorVertical);
        
        
        //Botonera derecha

        VBox contenedorVertical2 = new VBox(botonTurno);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));

        this.setRight(contenedorVertical2);

    }
    
    private void setBotonFinTurno(AlgoPoly aPoly) {



    }

    private void setMenu(Stage stage) {
    	
        this.menuBar = new BarraDeMenu(stage);
        
        this.setTop(menuBar);
    }

    /*private void setCentro(AlgoPoly aPoly) {

        canvasCentral = new Canvas(460, 220);
        vistaRobot = new VistaRobot(robot, canvasCentral);
        vistaRobot.dibujar();

        contenedorCentral = new VBox(canvasCentral);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(20);
        contenedorCentral.setPadding(new Insets(25));
        Image imagen = new Image("file:src/vista/imagenes/tablero.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        contenedorCentral.setBackground(new Background(imagenDeFondo));

        this.setCenter(contenedorCentral);
    }*/

    private void setConsola() {

        Label etiqueta = new Label();
        etiqueta.setText("Consola...");
        etiqueta.setFont(Font.font("courier new", FontWeight.SEMI_BOLD, 14));
        etiqueta.setTextFill(Color.WHITE);

        VBox contenedorConsola = new VBox(etiqueta);
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));
        contenedorConsola.setStyle("-fx-background-color: orange;");

        this.setBottom(contenedorConsola);
    }

    public BarraDeMenu getBarraDeMenu() {
        return menuBar;
    }

}

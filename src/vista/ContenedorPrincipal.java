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
import vista.eventos.BotonPagarFianzaHandler;

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
    }

    private void setBotonera(AlgoPoly aPoly) {

        Button botonDados = new Button();
        botonDados.setText("Arrojar dados");
        BotonArrojarDadosHandler dadosButtonHandler = new BotonArrojarDadosHandler();
        botonDados.setOnAction(dadosButtonHandler);

        Button botonFianza = new Button();
        botonFianza.setText("Pagar fianza");
        BotonPagarFianzaHandler fianzaButtonHandler = new BotonPagarFianzaHandler();
        botonFianza.setOnAction(fianzaButtonHandler);
        
        Button botonEdificar = new Button();
        botonEdificar.setText("Edificar");
        BotonEdificarHandler edificarButtonHandler = new BotonEdificarHandler();
        botonEdificar.setOnAction(edificarButtonHandler);
        
        

        VBox contenedorVertical = new VBox(botonFianza, botonEdificar, botonDados);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));

        this.setLeft(contenedorVertical);

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

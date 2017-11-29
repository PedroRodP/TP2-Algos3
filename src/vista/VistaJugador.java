package vista;

import java.util.concurrent.ConcurrentHashMap;

import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import modelo.Jugador;
import vista.eventos.Direccion;
import vista.eventos.Posicion;

public class VistaJugador {
	
	Canvas canvas;
	Jugador jugador;
	Paint color;
	Posicion posicion;
	Direccion direccion;
	ConcurrentHashMap<Direccion, Direccion> rotationMap;
	int casillerosAvanzados = 1;
	
	public VistaJugador(Canvas canvas, Jugador jugador, Paint color) {
		this.canvas = canvas;
		this.jugador = jugador;
		this.color = color;
		this.posicion = new Posicion(30, 30);
		this.direccion = Direccion.oeste();
		this.resetCanvas();
		
        this.rotationMap = new ConcurrentHashMap<>();
        this.rotationMap.put(Direccion.oeste(), Direccion.norte());
        this.rotationMap.put(Direccion.norte(), Direccion.este());
        this.rotationMap.put(Direccion.este(), Direccion.sur());
        this.rotationMap.put(Direccion.sur(), Direccion.oeste());
	}
	
	public void dibujar(int valorDados) {
	
        this.resetCanvas();
        
        for (int i = 0; i < valorDados; i++) {
        	
        	posicion.siguiente(direccion);
        	
        	if(avanzo5derecho()) {
        		this.rotar();
        	}
        }
        
        canvas.getGraphicsContext2D().setFill(color);
        canvas.getGraphicsContext2D().setGlobalAlpha(0.9);
        canvas.getGraphicsContext2D().fillOval(posicion.getX(), posicion.getY(), 20, 20);
    }
	
	private void rotar() {
		
		this.direccion = this.rotationMap.get(this.direccion); 
	}
	
	private boolean avanzo5derecho() {
		return (casillerosAvanzados == 5);
	}

	public void resetCanvas() {

        canvas.getGraphicsContext2D().setFill(color);
        canvas.getGraphicsContext2D().fillRect(0, 0, 360, 360);
        Image tablero = new Image("file:src/vista/imagenes/tablero.jpg");
        this.canvas.getGraphicsContext2D().drawImage(tablero, 0, 0);
    }

    public void update(int valorDados) {
        this.dibujar(valorDados);
    }
}

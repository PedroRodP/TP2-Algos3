package modelo;

public class Dado {

	public int tirar() {
		return (int) ((Math.random() * 5) + 1);
	}
}

package compartido;

import java.util.ArrayList;

public class Compartido {

	private ArrayList<String> arrayPalabras;
	private boolean salir;
	public static final int BUFFER_MAX_SIZE = 10;
	
	public Compartido() {
		this.arrayPalabras = new ArrayList<String>(BUFFER_MAX_SIZE);
		this.salir = true;
	}

	public ArrayList<String> getArrayPalabras() {
		return arrayPalabras;
	}

	public void setArrayPalabras(ArrayList<String> arrayPalabras) {
		this.arrayPalabras = arrayPalabras;
	}

	@Override
	public String toString() {
		return "Palabras almacenadas:\n\t" + arrayPalabras;
	}

	public boolean isSalir() {
		return salir;
	}

	public void setSalir(boolean salir) {
		this.salir = salir;
	}
	
}

package compartidos;

import java.util.Arrays;

public class ArraysCompartidos {

	private int[] arrayOrigen;
	private int[] arrayDestino;
	private int puntero;
	
	public ArraysCompartidos() {
		arrayOrigen = new int[10];
		
		arrayDestino = new int[10];
		puntero = -1;
	}

	public int[] getArrayOrigen() {
		return arrayOrigen;
	}

	public void setArrayOrigen(int[] arrayOrigen) {
		this.arrayOrigen = arrayOrigen;
	}

	public int[] getArrayDestino() {
		return arrayDestino;
	}

	public void setArrayDestino(int[] arrayDestino) {
		this.arrayDestino = arrayDestino;
	}

	public int getPuntero() {
		return puntero;
	}

	public void setPuntero(int puntero) {
		this.puntero = puntero;
	}

	@Override
	public String toString() {
		return "ArraysCompartidos [arrayOrigen=" + Arrays.toString(arrayOrigen) 
		+ ", arrayDestino=" + Arrays.toString(arrayDestino) 
		+ ", puntero=" + puntero + "]";
	}
	
	
	
}
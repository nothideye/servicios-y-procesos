package hilos;

public class HiloSuma extends Thread {

	private int[] arrayNumeros;
	private int suma;
	
	public HiloSuma(int[] arrayNumeros) {
		this.arrayNumeros = arrayNumeros;
	}

	public int[] getArrayNumeros() {
		return arrayNumeros;
	}

	public void setArrayNumeros(int[] arrayNumeros) {
		this.arrayNumeros = arrayNumeros;
	}

	public int getSuma() {
		return suma;
	}

	public void setSuma(int suma) {
		this.suma = suma;
	}

	@Override
	public void run() {
		
		for (int i = 0; i < arrayNumeros.length; i++) {
			suma += arrayNumeros[i];
		}
		
	}
	
}
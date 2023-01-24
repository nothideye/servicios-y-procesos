package hilos;

public class HilosParesImpares extends Thread {

	private int[] arrayNumeros;
	private int pares;
	private int impares;

	public HilosParesImpares(int[] arrayNumeros) {
		this.arrayNumeros = arrayNumeros;
		pares = 0;
		impares = 0;
	}

	public int[] getArrayNumeros() {
		return arrayNumeros;
	}

	public void setArrayNumeros(int[] arrayNumeros) {
		this.arrayNumeros = arrayNumeros;
	}

	public int getPares() {
		return pares;
	}

	public void setPares(int pares) {
		this.pares = pares;
	}

	public int getImpares() {
		return impares;
	}

	public void setImpares(int impares) {
		this.impares = impares;
	}

	@Override
	public void run() {
		
		for (int i = 0; i < arrayNumeros.length; i++) {
			if (arrayNumeros[i]%2==0) {
				pares ++;
			} else {
				impares ++;
			}
		}
		
	}
	
}
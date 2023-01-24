package hilos;

public class HiloMenor extends Thread {

	private int[] arrayNumeros;
	private int menor;
	
	public HiloMenor(int[] arrayNumeros) {
		this.arrayNumeros = arrayNumeros;
		menor = arrayNumeros[0];

	}
	
	public int[] getArrayNumeros() {
		return arrayNumeros;
	}

	public void setArrayNumeros(int[] arrayNumeros) {
		this.arrayNumeros = arrayNumeros;
	}

	public int getMenor() {
		return menor;
	}

	public void setMenor(int menor) {
		this.menor = menor;
	}

	@Override
	public void run() {
				
		for (int i = 0; i < arrayNumeros.length; i++) {
			
			if (arrayNumeros[i] < menor) {
				menor = arrayNumeros[i];
			} 
			
		}
		
	}
	
}
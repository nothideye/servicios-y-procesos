package hilos;

public class HiloProcesador extends Thread {

	private int min, max, suma;
	
	public HiloProcesador(int min, int max) {
		this.min = min;
		this.max = max;
		suma = 0;
	}
	
	@Override
	public void run() {
		
		for (int i = min; i <= max; i++) {
			suma += i;
		}
		
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public int getSuma() {
		return suma;
	}

	public void setSuma(int suma) {
		this.suma = suma;
	}
	
}
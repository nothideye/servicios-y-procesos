package hilos;

import compartidos.ArraysCompartidos;

public class HiloProcesador extends Thread {

	private ArraysCompartidos arrays;

	public HiloProcesador(String name, ArraysCompartidos arrays) {
		setName(name);
		this.arrays = arrays;
	}
	
	@Override
	public void run() {
		
		int cont = 0;
		
		do {
			
			while (cont > arrays.getPuntero()) {
				
				try {
					Thread.sleep(20);
				} catch (InterruptedException e) {
					System.err.println(e.getMessage());
				}
				
			}
			
			arrays.getArrayDestino()[cont] = arrays.getArrayOrigen()[cont];
			arrays.getArrayOrigen()[cont] = 0;
			cont ++;
			
		} while (cont < arrays.getArrayDestino().length);
		
	}
	
}
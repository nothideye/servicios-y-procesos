package hilos;

import java.util.Random;

import compartidos.ArraysCompartidos;

public class HiloProveedor extends Thread {
	
	private ArraysCompartidos arrays;

	public HiloProveedor(String name, ArraysCompartidos arrays) {
		setName(name);
		this.arrays = arrays;
	}
	
	@Override
	public void run() {
		
		Random random = new Random();
		
		for (int i = 0; i < arrays.getArrayOrigen().length; i++) {
			
			arrays.getArrayOrigen()[i] = random.nextInt(10);
			arrays.setPuntero(i);
			System.out.println(arrays.toString());
			
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}

		}
		
	}
	
}
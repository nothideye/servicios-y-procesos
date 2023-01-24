package main;

import hilos.HiloProcesador;

public class Main {

	/*
	public static void main(String[] args) {
		
		int suma = 0;
		long t0, t1;
		
		t0 = System.nanoTime();
		
		for (int i = 0; i < 1000000; i++) {
			suma += i;
		}
		
		t1 = System.nanoTime();
		
		System.out.println("La suma es " + suma + " y ha tardado " + (t1 - t0) + " nanosegundos.");

	}
	*/
	
	public static void main(String[] args) {
		
		long t0, t1;
		
		HiloProcesador h1 = new HiloProcesador(1, 7500000);
		HiloProcesador h2 = new HiloProcesador(7500001, 15000000);
		HiloProcesador h3 = new HiloProcesador(15000001, 22500000);
		HiloProcesador h4 = new HiloProcesador(22500001, 30000000);
		
		t0 = System.nanoTime();
		
		h1.start();
		h2.start();
		h3.start();
		h4.start();
		
		while (h1.isAlive() || h2.isAlive() || h3.isAlive() || h4.isAlive()) {
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
			
		}
		
		t1 = System.nanoTime();
		
		System.out.println("La suma es " + (h1.getSuma() + h2.getSuma() + h3.getSuma() + h4.getSuma()) + " y ha tardado " + (t1 - t0) + " nanosegundos.");
		
	}

}
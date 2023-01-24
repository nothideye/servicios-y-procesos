package main;

import compartidos.ArraysCompartidos;
import hilos.HiloProcesador;
import hilos.HiloProveedor;

public class Main {

	public static void main(String[] args) {

		ArraysCompartidos ac = new ArraysCompartidos();
		HiloProveedor h1 = new HiloProveedor("Proveedor", ac);
		HiloProcesador h2 = new HiloProcesador("Procesador", ac);
				
		h1.start();
		h2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println(ac.toString());
		
	}
}
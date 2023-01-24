package main;

import datosCompartidos.DatosCompartidos;
import hilos.Hilo1;
import hilos.Hilo2;

public class Main {

	public static void main(String[] args) {
		
		DatosCompartidos dc = new DatosCompartidos();
		Hilo1 h1 = new Hilo1(dc);
		Hilo2 h2 = new Hilo2(dc);
		
		h1.start();
		h2.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
		
		System.out.println("Soy el main y he acabado.");
		
	}
	
}
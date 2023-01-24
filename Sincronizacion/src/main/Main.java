package main;

import java.util.ArrayList;

import compartido.StringCompartido;
import hilos.HiloUno;

public class Main {
	// .join espera a que el otro hilo termine
	
	public static void main(String[] args) {
		
		StringCompartido stringCompartido = new StringCompartido();
		ArrayList<HiloUno> hilos = new ArrayList<>();
		int nHilos = 100;
		// Creamos hilos y añadimos a la lista
		for(int i = 1; i <=nHilos; i++) {
			hilos.add(new HiloUno("H" + i,stringCompartido));
		}
		
		// Arrancar cada hilo de la lista
		for (HiloUno h : hilos) {
			h.start();
		}
		
		// Obigar al hilo Main a esperar a todos los hilos de la lista
		for (HiloUno h : hilos) {
			try {
				h.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("La cadena es "+ stringCompartido.getString());
		System.out.println("La cadena tiene " + stringCompartido.getString().length() + " caracteres");
	}
}

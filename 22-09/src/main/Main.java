package main;

import java.util.ArrayList;

import datosCompartidos.DatosCompartidos;
import hilos.Hilo1;
import hilos.Hilo2;

public class Main {

	public static void main(String[] args) {
		
		DatosCompartidos dc = new DatosCompartidos(null);
		ArrayList<String> strings = new ArrayList<String>();
		Hilo1 h1 = new Hilo1(strings, dc);
		Hilo2 h2 = new Hilo2(dc);
		
		strings.add("Messi.");
		strings.add("Pedri.");
		strings.add("Lewandoski.");
		strings.add("Dembele.");
		strings.add("Ansu Fati.");
		
		h1.start();
		h2.start();
		
	}

}
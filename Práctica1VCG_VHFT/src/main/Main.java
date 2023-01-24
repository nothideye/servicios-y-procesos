package main;

import compartido.Compartido;
import hilos.HiloEscritor;
import hilos.HiloLector;

public class Main {

	public static void main(String[] args) {

		Compartido c = new Compartido();
		HiloLector hl = new HiloLector(c);
		HiloEscritor he = new HiloEscritor(c);
		
		hl.start();
		he.start();

	}

}
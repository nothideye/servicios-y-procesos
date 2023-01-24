package hilos;

import java.util.ArrayList;

import datosCompartidos.DatosCompartidos;

public class Hilo1 extends Thread {

	private ArrayList<String> strings = new ArrayList<String>();
	private DatosCompartidos dc;

	public Hilo1(ArrayList<String> strings, DatosCompartidos dc) {
		this.strings = strings;
		this.dc = dc;
	}
	
	/*
	 * 1º Escribe.
	 * 2º Espera a que se vacíe.
	 * 
	 * Una vez se acaben los Strings, indicar que finalizo.
	 */
	
	@Override
	public void run() {
		
		for (String s : strings) {
			dc.setPalabra(s);
			
			while (dc.getPalabra() != null) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					System.err.println(e.getMessage());
				}
			}
			
		}
		
		dc.setFlag(false);
		
	}
	
}
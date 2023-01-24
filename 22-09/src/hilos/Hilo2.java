package hilos;

import datosCompartidos.DatosCompartidos;

public class Hilo2 extends Thread {

	private DatosCompartidos dc;

	public Hilo2(DatosCompartidos dc) {
		this.dc = dc;
	}
	
	/*
	 * 1º Espera a que el Hilo1 ponga algo.
	 * 2º Escribe lo que ha puesto.
	 * 3º Vacía el String.
	 */
	
	@Override
	public void run() {
		
		while (dc.isFlag() == true) {
						
			while (dc.getPalabra() == null && dc.isFlag() == true) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					System.err.println(e.getMessage());
				}
			}
			
			System.out.println(dc.getPalabra());
			
			dc.setPalabra(null);

		}
		
	}
	
}
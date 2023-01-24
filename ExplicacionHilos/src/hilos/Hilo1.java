package hilos;

import datosCompartidos.DatosCompartidos;

public class Hilo1 extends Thread {

	private DatosCompartidos dc;
	
	public Hilo1(DatosCompartidos dc) {
		this.dc = dc;
	}
	
	@Override
	public void run() {
		
		for (int i = 0; i < 10000; i++) {
			System.out.println(i);
			
			dc.setFlag(true);
			
			while (dc.isFlag() == true) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					System.err.println(e.getMessage());
				}
			}
			
		}
		
	}
	
}
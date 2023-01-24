package hilos;

import datosCompartidos.DatosCompartidos;

public class Hilo2 extends Thread {

	private DatosCompartidos dc;
	
	public Hilo2(DatosCompartidos dc) {
		this.dc = dc;
	}
	
	@Override
	public void run() {
		
		for (int i = 0; i < 10000; i++) {
			
			while (dc.isFlag() == false) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					System.err.println(e.getMessage());
				}
			}
			
			System.out.println(i);
			
			dc.setFlag(false);

		}
		
	}

}
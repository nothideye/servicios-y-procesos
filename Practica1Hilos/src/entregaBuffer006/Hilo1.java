package entregaBuffer006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hilo1 extends Thread {
	
	private Compartido c;

	/*
	 * Constructores de Hilo1
	 */
	public Hilo1(Compartido c) {
		this.c = c;
	}
	public Hilo1() {
		
	}
	
	
	/*
	 * getters y setters
	 */
	public Compartido getC() {
		return c;
	}
	public void setC(Compartido c) {
		this.c = c;
	}

	
	/*
	 * run() del Thread Hilo2
	 */
	public void run() {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String lectura = "";
			
			while(!c.isTerminar()) {
				
				System.out.print("Escribe: ");
				try {
					lectura = reader.readLine();
					
					if(lectura.equals("exit")) {
						System.out.println("Fin");
						c.setTerminar(true);
					}else {
						c.getComp().add(lectura);
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}
}

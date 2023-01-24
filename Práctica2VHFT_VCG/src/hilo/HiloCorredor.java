package hilo;

import java.util.Random;

import main.Main;

public class HiloCorredor extends Thread {

	Random r = new Random();
	private int milisegundos;
	private String progreso = "";

	public HiloCorredor() {
		this.r = new Random();
	}

	public void run() {
		
					
		for (int i = 1; i <= 100; i++) {
			Random r = new Random();
			
			try {
				Thread.sleep(r.nextInt(50, 150));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (i%25==0) {
				progreso += "#####";
				Main.cambiar = true;
			}
			
		}
			
	}

	public Random r() {
		return r;
	}

	public int getMilisegundos() {
		return milisegundos;
	}

	public void setMilisegundos(int milisegundos) {
		this.milisegundos = milisegundos;
	}

	public String getProgreso() {
		return progreso;
	}

	public void setProgreso(String progreso) {
		this.progreso = progreso;
	}
	
}
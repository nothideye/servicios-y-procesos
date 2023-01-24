package primerejercicio;

import java.util.Random;

public class Hilo extends Thread {
	private int proceso;
	private static int rondas;
	private static boolean flag = true;
	public Hilo(int i) {

	}
	
	public int getProceso() {
		return proceso;
	}

	public void setProceso(int proceso) {
		this.proceso = proceso;
	}

	public static boolean isFlag() {
		return flag;
	}

	public static void setFlag(boolean flag) {
		Hilo.flag = flag;
	}

	public static int getRondas() {
		return rondas;
	}

	public static void setRondas(int rondas) {
		Hilo.rondas = rondas;
	}

	public void run() {

		Random r = new Random();
		int contador = 0;

		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		while (contador <= rondas) {
			proceso = proceso + r.nextInt(0, 10);
			contador++;
		}

		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		flag = true;
	}



}

package hilo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static ArrayList<Hilo> hilos = new ArrayList<Hilo>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		int num;
		int num2;

		System.out.println("Introduce el numero de hilos");
		num = sc.nextInt();

		System.out.println("Introduce el numero de rondas");
		num2 = sc2.nextInt();
		System.out.println("---------------------------------------------------------------");

		Hilo.setRondas(num2);

		for (int i = 0; i < num; i++) {
			hilos.add(new Hilo(i));

			hilos.get(i).start();
		}

		while (HilosVivos() == true) {
			if (Hilo.isFlag() == true) {
				for (int i = 0; i <= num2; i++) {
					System.out.println("Hilo " + i + " ---> " + hilos.get(i).getProceso());
				}
				System.out.println("---------------------------------------------------------------");
			}
			Hilo.setFlag(false);
		}

	}

	private static boolean HilosVivos() {
		boolean vivo = false;
		for (Hilo hilo : hilos) {
			if (hilo.isAlive()) {
				vivo = true;
			}
		}

		return vivo;
	}

}
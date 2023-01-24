package primerejercicio;

import java.util.ArrayList;
import java.util.Scanner;

import primerejercicio.Hilo;

public class Main {

	static ArrayList<Hilo>listaHilos = new ArrayList<Hilo>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		int primernum;
		int num2;

		System.out.println("Cuantos hilos");
		primernum = sc.nextInt();

		System.out.println("Cuantas rondas");
		num2 = sc2.nextInt();

		Hilo.setRondas(num2);

		for (int i = 0; i < primernum; i++) {
			listaHilos.add(new Hilo(i));

			listaHilos.get(i).start();
		}

		while (HilosVivos() == true) {
			if (Hilo.isFlag() == true) {
				for (int i = 0; i < listaHilos.size(); i++) {
					System.out.println("El hilo  numero: " + i + "vale:" +listaHilos.get(i).getProceso());
				}
			}
			Hilo.setFlag(false);
		}

	}

	private static boolean HilosVivos() {
		boolean vivo = false;
		for (Hilo h : listaHilos) {
			if (h.isAlive()) {
				vivo = true;
			}
		}

		return vivo;
	}

}

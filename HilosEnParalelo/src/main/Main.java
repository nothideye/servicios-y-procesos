package main;

import hilos.HiloMenor;
import hilos.HiloSuma;
import hilos.HilosParesImpares;

public class Main {

	public static void main(String[] args) {
		
		long t0, t1;
		
		int[] arrayNumeros = {4, 7, 2, 9, 6};
		
		HiloSuma hiloSuma = new HiloSuma(arrayNumeros);
		HiloMenor hiloMenor = new HiloMenor(arrayNumeros);
		HilosParesImpares hiloParesImpares = new HilosParesImpares(arrayNumeros);
		
		t0 = System.nanoTime();
		
		hiloSuma.start();
		hiloMenor.start();
		hiloParesImpares.start();
		
		while (hiloSuma.isAlive() || hiloMenor.isAlive() || hiloParesImpares.isAlive()) {
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
			
		}
		
		t1 = System.nanoTime();
		
		System.out.println("La suma total de los numeros introducidos es: " + hiloSuma.getSuma());
		System.out.println("El numero menor de todos los introducidos es: " + hiloMenor.getMenor());
		System.out.println("El numero total de numeros pares es: " + hiloParesImpares.getPares());
		System.out.println("El numero total de numeros impares es: " + hiloParesImpares.getImpares());
		System.out.println("El tiempo total que han tardado en realizar todos los calculos es de " + (t1 - t0) + " nanosegundos.");

	}

}
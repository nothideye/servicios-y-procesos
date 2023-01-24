package practicados;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	private static ArrayList<Participante> listaParticipantes = new ArrayList<Participante>();
	private static int numeroParticipantes;
	public static boolean flag;
	public static boolean flag2;
	public static int terminar;

	public static void main(String[] args) {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Participante p;

		System.out.println("¿Cuantos participantes habrá en la carrera?");
		do {
			try {
				numeroParticipantes = Integer.parseInt(br.readLine());
				flag = false;
			} catch (Exception e) {
				System.out.println("Numero entero por favor");
				flag = true;
			}

		} while (flag == true);
		
		// Creamos un bucle para que nos cree un objeto de tipo participante segun el numero de participantes que pedimos por parametros

		for (int i = 0; i < numeroParticipantes; i++) {
			p = new Participante();
			listaParticipantes.add(p);
			listaParticipantes.get(i).start();
		}
		verPorcentaje();
	}
	
	
	
	

	
	
	
	
	// Metodo que va recogiendo los datos y actualizandolos y los va imprimiendo segun los criterios del progreso
	public static void verPorcentaje() {

		for (int i = 0; i < listaParticipantes.size(); i++) {
			System.out.println("Participante " + (i + 1) + " - " 
					+ "[" + almohadillas(listaParticipantes.get(i).getAlmohadillas())
					+ "]" + " " + listaParticipantes.get(i).getAlmohadillas());
		}

		System.out.println();
		System.out.println("-------------------------------------------");
		System.out.println("--------------EMPEZAMOS--------------------");
		System.out.println("-------------------------------------------");
		System.out.println();

		while (checkAlive() == true) {

			if (flag2 == true) {

				for (int i = 0; i < listaParticipantes.size(); i++) {
					
					System.out.println("Participante " + (i + 1) + " - " + "["
							+ almohadillas(listaParticipantes.get(i).getAlmohadillas()) + "]" + " "
							+ listaParticipantes.get(i).getAlmohadillas());

					if (almohadillas(listaParticipantes.get(i).getAlmohadillas()).equals("100%")) {
						
						if (terminar == 0) {
							terminar = i + 1;
						}
					}
				}
				System.out.println();
				System.out.println("-------------------------------------------");
				System.out.println("--------------ACTUALIZANDO-----------------");
				System.out.println("-------------------------------------------");
				System.out.println();
				flag2 = false;

			}
		}
		
		System.out.println("--------------FIN PROGRAMA------------------");

		while (checkAlive() == true) {
			if (flag2 == true) {
				for (int i = 0; i < listaParticipantes.size(); i++) {

					System.out.println("Hilo " + (i + 1) + " --> " + listaParticipantes.get(i).getAlmohadillas() + " "
							+ almohadillas(listaParticipantes.get(i).getAlmohadillas()));

					if (almohadillas(listaParticipantes.get(i).getAlmohadillas()).equals("100%")) {
						if (terminar == 0) {
							terminar = i + 1;
						}
					}
				}

				flag2 = false;
			}
		}
	}
	
	// Nos permite ir actualizando el progreso de manera numerica con el porcentaje

	public static String almohadillas(String a) {
		String barraProgreso = "";

		switch (a) {
		case "":
			barraProgreso = "0%";
				break;

		case "####":
			barraProgreso = "25%";
				break;

		case "########":
			barraProgreso = "50%";
				break;

		case "############":
			barraProgreso = "75%";
				break;

		case "################":
			barraProgreso = "100%";
				break;

		default:
			break;
		}

		return barraProgreso;

	}

	// Metodo que comprueba si el thread esta vivo
	public static boolean checkAlive() {

		for (int i = 0; i < listaParticipantes.size(); i++) {

			if (listaParticipantes.get(i).isAlive()) {
				return true;
			}
		}

		return false;
	}
}

package main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import hilo.HiloCorredor;

public class Main {

	private static ArrayList<HiloCorredor> listaHilos = new ArrayList<HiloCorredor>();
	private static boolean entero;
	private static int numeroHilos;
	public static boolean cambiar;
	private static int gana;

	
	public static void main(String[] args) {

		HiloCorredor hc;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Introduce el número de participantes de la carrera.");

        do {

            try {
                numeroHilos = Integer.parseInt(br.readLine());
                entero = false;
            } catch (Exception e) {
                System.out.println("Introduce un número entero válido.");
                entero = true;
            }

        }while(entero == true);

        for (int i = 0; i < numeroHilos; i++) {
            hc = new HiloCorredor();
            listaHilos.add(hc);
            listaHilos.get(i).start();
                        
        }
                
        mostrarPorcentaje();
		System.out.println("\n-----------------------------");
		System.out.println("|                           |");
        System.out.printf("| El ganador es el Hilo %-3d |\n", gana);
        System.out.println("|                           |");
        System.out.println("-----------------------------");

    }

	public static boolean algunoVivo() {
		
		for (int i = 0; i < listaHilos.size(); i++) {
			
			if (listaHilos.get(i).isAlive()) {
				return true;
			}
			
		}
		
		return false;
		
	}
	
	public static String progreso(String p) {
		
		String resultado = "";
		
		switch (p) {
		case "":
			resultado = "0%";
			break;
			
		case "#####":
			resultado = "25%";
			break;
			
		case "##########":
			resultado = "50%";
			break;
			
		case "###############":
			resultado = "75%";
			break;
			
		case "####################":
			resultado = "100%";
			break;
			
		default:
			break;
		}
		
		return resultado;
		
	}
	
	private static void mostrarPorcentaje() {

		for (int i = 0; i < listaHilos.size(); i++) {
			
			System.out.println("Hilo " + (i+1) + " --> " + listaHilos.get(i).getProgreso() + " " + progreso(listaHilos.get(i).getProgreso()));
			
		}
		
		System.out.println("=======================================");
		
		while (algunoVivo()==true) {
			
			if (cambiar == true) {
				
				for (int i = 0; i < listaHilos.size(); i++) {
					
					System.out.println("Hilo " + (i+1) + " --> " + listaHilos.get(i).getProgreso() + " " + progreso(listaHilos.get(i).getProgreso()));
						
					if (progreso(listaHilos.get(i).getProgreso()).equals("100%")) {
						
						if (gana == 0) {
							gana = i+1;
						}
						
					}
					
				}
				
				System.out.println("=======================================");
				cambiar = false;
			}
		
		}

	}
	
}
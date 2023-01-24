package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa el número de plantas del edificio: ");
        int numPisos = sc.nextInt();
        System.out.print("Ingresa el número de personas que van a llegar al edificio: ");
        int numPersonas = sc.nextInt();
        Edificio edificio = new Edificio(numPisos, numPersonas);
    }
	}



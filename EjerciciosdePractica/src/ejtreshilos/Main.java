package ejtreshilos;

import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
			
		System.out.println("Introduce el primer numero");
		BufferedReader br = new BufferedReader(null);
		try {
			String opcionUno = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

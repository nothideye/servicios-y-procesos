package hilos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import compartido.Compartido;

public class HiloLector extends Thread {
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	String lectura = "";
	Compartido ac;
	
	public HiloLector(Compartido ac) {
		this.ac = ac;
	}

	@Override
	public void run() {
		
		do {
				
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		
		} while (ac.getArrayPalabras().size() == Compartido.BUFFER_MAX_SIZE);	
		
		try {
			
			System.out.println("Introduzca las palabras que desea almacenar. Para salir, escriba \"exit\".");
			
			do {
				
				lectura = br.readLine();
				
				if (!lectura.equalsIgnoreCase("exit")) {
					ac.getArrayPalabras().add(lectura);
					System.out.println(ac.getArrayPalabras());
				}
				
			} while (!lectura.equalsIgnoreCase("exit"));
			
			System.out.println(ac.getArrayPalabras());
			
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
		
		ac.setSalir(false);
		
	}	
	
}
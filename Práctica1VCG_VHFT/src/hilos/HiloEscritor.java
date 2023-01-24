package hilos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import compartido.Compartido;

public class HiloEscritor extends Thread {

	private Compartido c;
	private File f = new File("DatosEscritos.txt");
	private FileWriter fw;
	private BufferedWriter bw;
	
	public HiloEscritor(Compartido c) {
		this.c = c;
	}

	@Override
	public void run() {
				
		do {
			
			while (!c.getArrayPalabras().isEmpty()) {

				try {
					
					fw = new FileWriter(f, true);
					bw = new BufferedWriter(fw);
					
					fw.write(c.getArrayPalabras().get(0) + "\n");
					c.getArrayPalabras().remove(0);
					
					fw.close();
					bw.close();
					
				} catch (IOException e) {
					System.err.println(e.getMessage());
				}
				
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
			
		} while (c.isSalir() == true);

	}
	
}
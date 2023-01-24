package entregaBuffer006;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Hilo2 extends Thread {
	
	static String path = "almacen.txt";
	
	private Compartido c;
	private File almacen = new File(path);
	
	/*
	 * Constructores de Hilo2
	 */
	public Hilo2(Compartido c) {
		this.c = c;
	}
	public Hilo2() {
		
	}
	
	
	/*
	 * getters y setters
	 */
	public Compartido getC() {
		return c;
	}
	public void setC(Compartido c) {
		this.c = c;
	}
	public File getAlmacen() {
		return almacen;
	}
	public void setAlmacen(File almacen) {
		this.almacen = almacen;
	}

	
	/*
	 * run() del Thread Hilo2
	 */
	public void run() {
		primerPaso();
		
		while(!c.isTerminar()) {
			
			/*
			 * Si el array compartido está vacío y terminar está en falso aún, que duerma
			 */
			while((c.getComp().isEmpty()) && (!c.isTerminar())) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			/*
			 * Cuando el array compartido deje de estar vacío
			 */
			if(!c.getComp().isEmpty()) {
				try {
					FileWriter fw = new FileWriter(almacen, true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(fw);
					
					String elemento = c.getComp().get(0);
					pw.println(elemento);
					c.getComp().remove(0);
					
					pw.close();
					bw.close();
					fw.close();
				} catch (IOException e) {
					System.out.println("No se ha podido almacenar el dato");
					e.printStackTrace();
				}	
			}
		}
	}
	
	
	/*
	 * Método que comprueba si el archivo existe, y si existe, lo elimina y lo vuelve a crear, para que no se duplique 
	 * ni de errores en cada ejecución; se ejecuta al principio del programa
	 */
	public static File primerPaso() {		
		/*
		 * comprueba si existe el archivo, si sí, lo elimina
		 */
		File checkAlmacen = new File(path);
		if(checkAlmacen.exists()) {
			checkAlmacen.delete();
		}

		/*
		 * crea el nuevo archivo
		 */
		checkAlmacen = new File(path);
		try {
			checkAlmacen.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return checkAlmacen;
	}
	
}

package segundoejercicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HiloConsumidor extends Thread {
	
	static String path = "ruta.txt";
	private Compartido c;
	private File f = new File(path);
	
	
	
	public HiloConsumidor(String path, Compartido c, File f) {
		super();
		this.path = path;
		this.c = c;
		this.f = f;
	}
	
	public HiloConsumidor() {
		
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Compartido getC() {
		return c;
	}

	public void setC(Compartido c) {
		this.c = c;
	}

	public File getF() {
		return f;
	}

	public void setF(File f) {
		this.f = f;
	}
	
	
	public void run() {
		comprobarArchivoExiste();
		
		while(!c.isTerminar()) {
			while(c.getListaNumeros().isEmpty() && (!c.isTerminar())) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			if(!c.getListaNumeros().isEmpty()) {
				try {
					FileWriter fw = new FileWriter(f, true);
					BufferedWriter bw = new BufferedWriter(fw);
					PrintWriter pw = new PrintWriter(fw);
					int elemento = c.getListaNumeros().get(0);
					pw.println(elemento);
					c.getListaNumeros().remove(0);
					
					pw.close();
					bw.close();
					fw.close();
				} catch (IOException e) {
					System.out.println("no se pudo guardar los numeros");
					e.printStackTrace();
				}
				
			}
			
		}
		
		
	}
	
	
	public static File comprobarArchivoExiste() {		

		File f = new File(path);
		if(f.exists()) {
			f.delete();
		}

		f = new File(path);
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return f;
	}

}

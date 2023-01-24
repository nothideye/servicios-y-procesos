package segundoejercicio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static Compartido c = new Compartido();
	static  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) {

		
		HiloProvedor h1 = new HiloProvedor(c);
		HiloConsumidor h2 = new HiloConsumidor(null, c, null);
		
		h1.start();
		h2.start();
		
		while(h1.isAlive() || h2.isAlive()) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	

	}

}

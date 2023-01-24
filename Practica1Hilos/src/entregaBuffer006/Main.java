package entregaBuffer006;

public class Main {

	static Compartido c = new Compartido();
	
	public static void main(String[] args) {
		Hilo1 h1 = new Hilo1(c);
		Hilo2 h2 = new Hilo2(c);
		
		h1.start();
		h2.start();
		
		while(h1.isAlive() || h2.isAlive()) {
			try {
				Thread.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}

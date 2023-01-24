package clase_thread;

public class Main {

	public static void main(String[] args) {

		Hilo h1 = new Hilo("PRIMERO");
		Hilo h2 = new Hilo("SEGUNDO");
		Hilo h3 = new Hilo("TERCERO");
		
		h1.start();
		/*
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
		*/
		
		h2.start();
		/*
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}
		*/
		
		h3.start();
		
		System.out.println("Soy el main. Ya he acabado mi parte. Me muero.");
	}

}
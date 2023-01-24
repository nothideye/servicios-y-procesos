package clase_thread;

/* public class Hilo implements Runnable */

public class Hilo extends Thread {
	
	public Hilo(String name) {
		this.setName(name);
	}
	
	@Override
	public void run() {
		
		for (int i = 1; i <= 10; i++) {
			
			System.out.println("Soy el hilo " + this.getName() + " y estoy en la vuelta " + i + ".");

			/*
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());			
			}
			*/
			
		}
	
		System.out.println("Soy el hilo " + this.getName() + " y he acabado."); 
	}
}
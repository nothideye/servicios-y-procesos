package hilos;

import compartidos.Caja;

public class Dependiente extends Thread {
	
	private Caja caja;
	private Cliente cliente;
	
	public Dependiente(String name, Caja caja, Cliente cliente) {
		setName(name);
		this.cliente = cliente;
		this.caja = caja;
		
	}
	
	
	public void run() {
		// Mientras el cliente siga haciendo cosas (esté vivo)
		// O
		// Mientras queden productos en la cinta
		while(cliente.isAlive() || !caja.getCinta().isEmpty()) {
			caja.escanearProducto();
		}
		
		
		System.out.println("El ticket  de compra: \n" + caja.getTicket());
		
	}

}

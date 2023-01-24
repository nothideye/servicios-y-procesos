package compartidos;

import java.util.ArrayList;

public class Caja {
	
	private ArrayList<Producto> cinta;
	private String ticket;
	private int capacidad;
	
	
	public Caja(int capacidad) {
		cinta = new ArrayList<>(capacidad);
		ticket = "";
		this.capacidad = capacidad;
	}
	
	
	public synchronized void ponerProducto(Producto producto) {
		
		/*
		 *  1. ¿Esta la cinta saturada?
		 *  -> Esperar que haya hueco
		 *  2. Añadir producto a la cinta
		 *  3. Notificar a la otra persona por si acaso está esperando
		 */
		
		while (cinta.size() == capacidad) {
			try {
				// Hilo se bloquea hasta ser notificado
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		cinta.add(producto);
		
		notifyAll();
		
		
	}
	
	
	public synchronized void escanearProducto() {

		/*
		 *  1. ¿Esta la cinta vacia?
		 *  -> Esperar que a que pongan un producto minimo
		 *  2. Eliminar producto de la cinta
		 *  3. Anyadir linea al ticket
		 *  4. Notificar a la otra persona por si eta esperando
		 */
		
		while(cinta.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		Producto p = cinta.remove(0);	
		ticket += p.getNombre() + " -> " + p.getPrecio() + "\n";
		notifyAll();
		
	}
	
	
	public synchronized ArrayList<Producto> getCinta(){
		return cinta;
	}
	
	public String getTicket() {
		return ticket;
	}

}
